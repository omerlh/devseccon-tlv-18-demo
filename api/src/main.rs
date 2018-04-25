#![feature(plugin, decl_macro)]
#![plugin(rocket_codegen)]

extern crate rocket;
#[macro_use] extern crate rocket_contrib;

use rocket_contrib::{Json};

#[get("/")]
fn hello() ->  Json  {
    Json(json!({
        "dev": "http://jobs.soluto.com/apply/NxK0Kn/Senior-Software-Engineer",
        "dev-ops": "http://jobs.soluto.com/apply/y05XIq/Production-Engineer-DevOps",
        "pm": "http://jobs.soluto.com/apply/izeE6HhNuv/Senior-Product-Manager",
        "ux": "http://jobs.soluto.com/apply/9lFp0fCtus/Graphic-Designer"
      }))
}

fn main() {
    rocket::ignite().mount("/", routes![hello]).launch();
}