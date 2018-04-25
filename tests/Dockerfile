FROM microsoft/dotnet:2.0-sdk

WORKDIR /app

COPY install_dependencies.sh ./
RUN ./install_dependencies.sh

COPY tests.csproj .

RUN dotnet restore

COPY . .

CMD ["bash", "run_test.sh"]