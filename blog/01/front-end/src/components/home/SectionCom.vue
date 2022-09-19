<template>
  <div>
    <!-- AboutMe-->
    <section class = "content-section bg-light"
             id = "AboutMe"
    >
      <div class = "container px-4 px-lg-5 text-center">
        <div class = "row gx-5 gx-lg-5 justify-content-center">
          <div class = "col-10">
            <h1 class = "mb-5">About Me</h1>
            <!--첫 번째 줄 시작-->
            <div class = "row">
              <div class = "col-lg-3 col-md-5 col-sm-10 my-1 mx-auto">
                <table class = "table-borderless border-light">
                  <tr>
                    <td rowspan = "2"
                    ><i class = "h1 bi bi-person"
                    ></i></td>
                    <td class = "py-2 px-3"><strong>이름</strong></td>
                  </tr>
                  <tr>
                    <td class = "py-2 px-3">이구민</td>
                  </tr>
                </table>
              </div>
              <div class = "col-lg-3 col-md-5 col-sm-10 my-1 mx-auto">
                <table class = "table-borderless border-light">
                  <tr>
                    <td rowspan = "2"
                        class = "aboutIcon"
                    ><i class = "h1 bi bi-balloon"
                    ></i></td>
                    <td class = "py-2 px-3"><strong>생년월일</strong></td>
                  </tr>
                  <tr>
                    <td class = "py-2 px-3">1991.01.06</td>
                  </tr>
                </table>
              </div>
              <div class = "col-lg-3 col-md-5 col-sm-10 my-1 mx-auto">
                <table class = "table-borderless border-light">
                  <tr>
                    <td rowspan = "2"
                        class = "aboutIcon"
                    ><i class = "h1 bi bi-house"
                    ></i></td>
                    <td class = "py-2 px-3"><strong>주소지</strong></td>
                  </tr>
                  <tr>
                    <td class = "py-2 px-3">부산시 사하구</td>
                  </tr>
                </table>
              </div>
            </div>
            <!--첫 번째 줄 끝-->
            <!--두 번째 줄 시작-->
            <div class = "row">
              <div class = "col-lg-3 col-md-5 col-sm-10 my-1 mx-auto">
                <table class = "table-borderless border-light">
                  <tr>
                    <td rowspan = "2"
                    ><i class = "h1 bi bi-envelope"
                    ></i></td>
                    <td class = "py-2 px-3"><strong>이메일</strong></td>
                  </tr>
                  <tr>
                    <td class = "py-2 px-3">littlegbear@naver.com</td>
                  </tr>
                </table>
              </div>
              <div class = "col-lg-3 col-md-5 col-sm-10 mx-auto">
                <table class = "table-borderless border-light">
                  <tr>
                    <td rowspan = "2"
                        class = "aboutIcon"
                    ><i class = "h1 bi bi-phone"
                    ></i></td>
                    <td class = "py-2 px-3"><strong>연락처</strong></td>
                  </tr>
                  <tr>
                    <td class = "py-2 px-3">010-5408-5454</td>
                  </tr>
                </table>
              </div>
              <div class = "col-lg-3 col-md-5 col-sm-10 mx-auto">
                <table class = "table-borderless border-light">
                  <tr>
                    <td rowspan = "2"
                        class = "aboutIcon"
                    ><i class = "h1 bi bi-book"
                    ></i></td>
                    <td class = "py-2 px-3"><strong>학력</strong></td>
                  </tr>
                  <tr>
                    <td class = "py-2 px-3">순천대학교 학사</td>
                  </tr>
                </table>
              </div>
            </div>
            <!--두 번째 줄 끝-->
          </div>
        </div>
      </div>
    </section>
    <!-- Skills-->
    <section class = "content-section text-dark text-center"
             id = "Skills"
    >
      <div class = "container px-4 px-lg-5">
        <div class = "content-section-heading">
          <h2 class = "mb-5">Skills</h2>
        </div>
        <!--        <div class = "row gx-4 gx-lg-5">
                  <div class = "col-lg-3 col-md-6 mb-5 mb-lg-0">
                    <span class = "service-icon rounded-circle mx-auto mb-3"><i class="bi bi-filetype-java"></i></span>
                    <h4><strong>Responsive</strong></h4>
                    <p class = "text-faded mb-0">Looks great on any screen size!</p>
                  </div>
                  <div class = "col-lg-3 col-md-6 mb-5 mb-lg-0">
                    <span class = "service-icon rounded-circle mx-auto mb-3"><i class = "icon-pencil"></i></span>
                    <h4><strong>Redesigned</strong></h4>
                    <p class = "text-faded mb-0">Freshly redesigned for Bootstrap 5.</p>
                  </div>
                  <div class = "col-lg-3 col-md-6 mb-5 mb-md-0">
                    <span class = "service-icon rounded-circle mx-auto mb-3"><i class = "icon-like"></i></span>
                    <h4><strong>Favorited</strong></h4>
                    <p class = "text-faded mb-0">
                      Millions of users
                      <i class = "fas fa-heart"></i>
                      Start Bootstrap!
                    </p>
                  </div>
                  <div class = "col-lg-3 col-md-6">
                    <span class = "service-icon rounded-circle mx-auto mb-3"><i class = "icon-mustache"></i></span>
                    <h4><strong>Question</strong></h4>
                    <p class = "text-faded mb-0">I mustache you a question...</p>
                  </div>
                </div>-->
        <div class = "row row-cols-1 row-cols-md-3 g-4">
          <div class = "col">
            <div class = "card">
              <div class = "card-body">
                <h5 class = "card-title h2">Frontend</h5>
                <hr>
                <div class="card-img-bottom">
                  <img src = "@/assets/img/html5.jpg"
                       class = "card-img-bottom my-2"
                       alt = "HTML5_CSS_JS"
                  >
                  <img src = "@/assets/img/axios.jpg"
                       class = "card-img-bottom my-2"
                       alt = "Axios"
                  >
                </div>
              </div>
            </div>
          </div>
          <div class = "col">
            <div class = "card">
              <div class = "card-body">
                <h5 class = "card-title h2">Backend</h5>
                <hr>
                <div class="card-img-bottom">
                  <img src = "@/assets/img/spring_boot.jpg"
                       class = "card-img-bottom my-2"
                       alt = "SpringBoot"
                  >
                  <img src = "@/assets/img/spring_security.jpg"
                       class = "card-img-bottom my-2 w-75"
                       alt = "SpringSecurity"
                  >
                  <img src = "@/assets/img/java.jpg"
                       class = "card-img-bottom my-2 me-4"
                       style="width: 20%;"
                       alt = "JAVA"
                  >
                  <img src = "@/assets/img/mybatis.jpg"
                       class = "card-img-bottom my-2 w-25 ms-3"
                       alt = "MyBatis"
                  >
                </div>
              </div>
            </div>
          </div>
          <div class = "col">
            <div class = "card">
              <div class = "card-body">
                <h5 class = "card-title h2">Database</h5>
                <hr>
                <div class="card-img-bottom">
                  <img src = "@/assets/img/oracle.jpg"
                       class = "card-img-bottom my-2"
                       alt = "Oracle"
                  >
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Portfolio-->
    <section class = "content-section"
             id = "Project"
    >
      <div class = "container px-4 px-lg-5">
        <div class = "content-section-heading text-center">
          <h2 class = "mb-5">Project</h2>
        </div>
        <div class = "row gx-0">
          <div class = "col-lg-6 mx-auto">
            <a class = "portfolio-item"
               href = "https://github.com/Leegumin/TeamProject"
            >
              <div class = "caption">
                <div class = "caption-content">
                  <div class = "h1">FEET' IN</div>
                  <p class = "mb-0">팀프로젝트(이구민, 강수정, 김주영, 김종호, 오은진)</p>
                  <p class = "mb-0 h2">신발 전문 판매 쇼핑몰</p>
                </div>
              </div>
              <img class = "img-fluid"
                   src = "@/assets/img/mainpage.jpg"
                   alt = "..."
                   style="opacity: 0.5"
              />
            </a>
          </div>
<!--          <div class = "col-lg-6">
            <a class = "portfolio-item"
               href = "#!"
            >
              <div class = "caption">
                <div class = "caption-content">
                  <div class = "h2">Ice Cream</div>
                  <p class = "mb-0">A dark blue background with a colored pencil, a clip, and a tiny ice cream cone!</p>
                </div>
              </div>
              <img class = "img-fluid"
                   src = "@/assets/img/portfolio-2.jpg"
                   alt = "..."
              />
            </a>
          </div>-->
        </div>
      </div>
    </section>
  </div>
</template>

<script>
export default {
  name: 'SectionCom',
}
</script>

<style scoped>
#aboutMe tr > td, th {
  padding: 20px 50px;
}

#aboutMe tr > .aboutIcon {
  padding: 25px;
}

#Skills {
  background-color: #68a1f5;
}
#Project {
  background-color: #99c0fa;
}

.card {
  box-shadow: 5px 5px 5px 5px #313131;
  border-radius: 5%;
}

.card-img-bottom > img {
  width: 80%;
}
</style>