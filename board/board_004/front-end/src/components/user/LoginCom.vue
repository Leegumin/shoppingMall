<template>
  <div id = "body"
       class = "text-center mx-auto"
  >
    <main class = "form-signin bg-white vh-100">
      <!--브랜드 로고 및 메인 바로가기 시작-->
      <div class = "mb-4">
        <router-link to = "/"><strong class = "h2 text-black">NOSINSA</strong></router-link>
      </div>
      <!--브랜드 로고 및 메인 바로가기 끝-->
      <form>
        <!--이메일 입력 창 시작-->
        <div class = "form-floating">
          <input type = "email"
                 class = "form-control border-dark mb-1 rounded-2"
                 id = "floatingInput"
                 placeholder = "name@example.com"
          >
          <label for = "floatingInput">Email address</label>
        </div>
        <!--이메일 입력 창 끝-->
        <!--비밀번호 입력 창 시작-->
        <div class = "form-floating">
          <input type = "password"
                 class = "form-control border-dark rounded-2"
                 id = "floatingPassword"
                 placeholder = "Password"
          >
          <label for = "floatingPassword">Password</label>
        </div>
        <!--비밀번호 입력 창 끝-->

<!--        <div class = "checkbox mb-3">
          <label>
            <input type = "checkbox"
                   value = "remember-me"
            > Remember me
          </label>
        </div>-->

        <!--로그인 버튼 시작-->
        <button class = "w-100 btn btn-lg btn-dark"
                type = "submit"
        >Sign in
        </button>
        <!--로그인 버튼 끝-->
        <!--회원가입 홈페이지로 이동 시작-->
        <router-link to = "/register"
                     class = "text-white"
        >
          <button class = "w-100 btn btn-lg btn-dark mt-2"
                  type = "submit"
          >
            Sign up
          </button>
        </router-link>
        <!--회원가입 홈페이지로 이동 끝-->
        <!--아이디, 비밀번호 찾기 시작-->
        <div class = "mt-2">
          <router-link to = "#"
                       class = "text-black"
          >Find Email
          </router-link>
          <span class = "text-black"> | </span>
          <router-link to = "#"
                       class = "text-black"
          >Find Password
          </router-link>
        </div>
        <!--아이디, 비밀번호 찾기 시작-->
      </form>
    </main>
  </div>
</template>

<script>
export default {
  /* eslint-disable */
  name: 'Login',
}
</script>

<style scoped>
#body {
  background-color: #f5f5f5;
}

.form-signin {
  width: 100%;
  max-width: 450px;
  padding: 30px;
  margin: auto;
}

.form-signin .checkbox {
  font-weight: 400;
}

.form-signin .form-floating:focus-within {
  z-index: 2;
}

.form-signin input[type="email"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}

.bd-placeholder-img {
  font-size: 1.125rem;
  text-anchor: middle;
  -webkit-user-select: none;
  -moz-user-select: none;
  user-select: none;
}

@media (min-width: 768px) {
  .bd-placeholder-img-lg {
    font-size: 3.5rem;
  }
}

a {
  text-decoration: none;
}
</style>