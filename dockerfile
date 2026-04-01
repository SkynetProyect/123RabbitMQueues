# --------------------------
# Stage 1: Build with GraalVM
# --------------------------
FROM ghcr.io/graalvm/native-image:ol8-java17-22.3.3 AS build

# Instala herramientas necesarias
RUN microdnf install -y curl unzip git findutils util-linux

WORKDIR /project

COPY . .

RUN chmod +x ./gradlew

#  (Gradle task: nativeBuild)
RUN ./gradlew :appservice:buildNativeImage 

# --------------------------
# Stage 2: Runtime minimal
# --------------------------
FROM alpine:3.18

RUN apk add --no-cache libc6-compat

# Copia el binario nativo desde la etapa build
# Ajusta la ruta según tu proyecto: build/native/nativeCompile/myapp
COPY --from=build /project/build/native/nativeCompile/myapp /usr/local/bin/myapp

# Define el binario como entrypoint
ENTRYPOINT ["/usr/local/bin/myapp"]