FROM ruby:alpine

WORKDIR /app

COPY install_dependencies.sh ./
RUN ./install_dependencies.sh && gem install rspec

COPY . .

CMD ["bash", "run_test.sh"]