#Source: https://whitfin.io/speeding-up-rust-docker-builds/

FROM rustlang/rust:nightly

WORKDIR /usr/src

RUN USER=root cargo new app

WORKDIR /usr/src/app

COPY Cargo.toml .

RUN cargo build --release

RUN rm src/*.rs

COPY ./src ./src

RUN cargo build --release \
    && mv target/release/app /bin \
    && rm -rf /usr/src/app

CMD ["/bin/app"]