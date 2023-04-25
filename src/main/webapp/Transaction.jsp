<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title> EthioBank Create New Account</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
      crossorigin="anonymous"
    />
    <script
      src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"
      integrity="sha384-oBqDVmMz9ATKxIep9tiCxS/Z9fNfEXiDAYTujMAeBAsjFuCZSmKbSSUnQlmh/jp3"
      crossorigin="anonymous"
    ></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"
      integrity="sha384-mQ93GR66B00ZXjt0YO5KlohRA5SY2XofN4zfuZxLkoj1gXtW8ANNCe9d5Y3eG5eD"
      crossorigin="anonymous"
    ></script>
  </head>
  <body style="background-color: gery ">
    <main>
      <div class="container">
        <div class="row justify-content-center">
          <div class="col-xxl-7 col-xl-10">
            <div
              class="card card-raised-shadow-10 mt-5 mb-5 mt-xl-10"
              style="
                background-color: rgb(250, 250, 250);
                border-color: darkblue;
              "
            >
              <!--to have 10 paragraph size-->
              <div class="card-body p-10">
                <div class="text-center">
                  <p>
                    <svg
                      xmlns="http://www.w3.org/2000/svg"
                      width="55"
                      height="55"
                      fill="#6b09eb"
                      class="bi bi-hexagon-fill"
                      viewBox="0 0 16 16"
                    >
                      <path
                        fill-rule="evenodd"
                        d="M8.5.134a1 1 0 0 0-1 0l-6 3.577a1 1 0 0 0-.5.866v6.846a1 1 0 0 0 .5.866l6 3.577a1 1 0 0 0 1 0l6-3.577a1 1 0 0 0 .5-.866V4.577a1 1 0 0 0-.5-.866L8.5.134z"
                      />
                    </svg>
                  </p>
              
                   <h1 class="display-5">Ethio Bank</h1>
                  <h6 class="subhading-1 mb=5">Fill The Following Form To Have Account </h6>
                </div>
                <!--for input form-->
                <form action="login.html" novalidate>
                  <div class="row mt-5">
                    <div class="col-sm-6 mb-4 ">
                      <div class="form-floating">
                        <input
                          type="text"
                          class="form-control"
                          autocomplete="off"
                          id="firstName"
                          placeholder="First Name"
                          required
                        />
                        <label for="firstName">First Name</label>
                        <div class="invalid-feedback">First Name Is Required </div>
                      </div>
                    </div>
                    <div class="col-sm-6 mb-4 ">
                      <div class="form-floating">
                        <input
                          type="text"
                          class="form-control"
                          autocomplete="off"
                          id="lastName"
                          placeholder="Last Name"
                          required
                        />
                        <label for="lastName">Last Name </label>
                        <div class="invalid-feedback">Last Name Is Required </div>

                      </div>
                    </div>
                  </div>
                  <!--this is the  email row -->
                  <div class="form-floating mb-4">
                    <input
                      type="email"
                      class="form-control"
                      autocomplete="off"
                      id="idEmail"
                      placeholder="name@example.com"
                      required
                      disabled="disabled"
                    />
                    <label for="idEmail">Email Address</label>
                    <div class="invalid-feedback">Email Address Is Required </div>
                  </div>
                  <!--this is the password row -->
                  <div class="row">
                    <div class="col-sm-6 mb-4">
                      <div class="form-floating">
                        <input
                          type="password"
                          class="form-control"
                          autocomplete="off"
                          id="idPassword"
                          placeholder="Password"
                          required
                        />
                        <label for="idPassword">Password</label>
                        <div class="invalid-feedback">Password Is Required </div>

                      </div>
                    </div>
                    <div class="col-sm-6 mb-4">
                      <div class="form-floating">
                        <input
                          type="password"
                          class="form-control"
                          autocomplete="off"
                          id="verifyPassword"
                          placeholder="Password"
                         required
                        />
                        <label for="verifyPassword">Verify Password</label>
                        <div class="invalid-feedback">Verify Password Is Required </div>
                      </div>
                    </div>
                  </div>
                  <div class="form-check mb-5">
                    <input
                      class="form-check-input"
                      type="checkbox"
                      placeholder="un"
                      value="agreed"
                      name="agreement"
                      id="agreement"
                      required
                    />
                    <label class="form-check-label" for="agreement">
                      I agree to the website terms and conditions
                    </label>
                    <div class="invalid-feedback">You must agree the website agreement  </div>

                  </div>
                  <div
                    class="form-group d-flex align-items-center justify-content-between mt-4 mb-0"
                  >
                    <a href="login.html" class="text-decoration-none"
                      >Sign In Instead</a
                    >
                    <button type="submit" class="btn btn-primary">
                      CREATE ACCOUNT
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
    <footer class="p-4">
      <!-- place footer here -->
      <div
        class="d-flex flex-column flex-sm-row align-items-center justify-content-between small"
      >
        <div class="me-sm-3 mb-2 mb-sm-0">
          <div class="fw-500 text-white">Copyright © Your Website 2023</div>
        </div>
        <div class="ms-sm-3">
          <a class="fw-500 text-decoration-none text-white" href="#">Privacy</a>
          <a class="fw-500 text-decoration-none mx-4 text-white" href="#"
            >Terms</a
          >
          <a class="fw-500 text-decoration-none text-white" href="#">Helps</a>
        </div>
      </div>
    </footer>
    <script src="../JS/formValidation.js"></script>
    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN"
      crossorigin="anonymous"
    ></script>
</body>
</html>