<template>
  <div>
    <!-- About-->
    <section class = "content-section bg-light"
             id = "about"
    >
      <div class = "container px-4 px-lg-5 text-center">
        <div class = "row gx-4 gx-lg-5 justify-content-center">
          <div class = "col-lg-10">
            <h1>About</h1>
            <div class = "d-inline-block">
              <table class = "table-borderless"
                     id = "aboutMe"
              >
                <!--첫 번째 줄 시작-->
                <tr>
                  <td rowspan = "2"
                      class = "aboutIcon"
                  ><h1><i class = "bi bi-person"
                  ></i></h1></td>
                  <th>이름</th>
                  <td rowspan = "2"
                      class = "aboutIcon"
                  ><h1><i class = "bi bi-balloon"></i></h1></td>
                  <th>생년월일</th>
                  <td rowspan = "2"
                      class = "aboutIcon"
                  ><h1><i class = "bi bi-house"></i></h1></td>
                  <th>주소지</th>
                </tr>
                <tr>
                  <td>이구민</td>
                  <td>1991.01.06</td>
                  <td>부산시 사하구</td>
                </tr>
                <!--첫 번째 줄 끝-->
                <!--두 번째 줄 시작-->
                <tr>
                  <td rowspan = "2"
                      class = "aboutIcon"
                  ><h1><i class = "bi bi-envelope"></i></h1></td>
                  <th>이메일</th>
                  <td rowspan = "2"
                      class = "aboutIcon"
                  ><h1><i class = "bi bi-phone"></i></h1></td>
                  <th>연락처</th>
                  <td rowspan = "2"
                      class = "aboutIcon"
                  ><h1><i class = "bi bi-book"></i></h1></td>
                  <th>학력</th>
                </tr>
                <tr>
                  <td>littlegbear@naver.com</td>
                  <td>010-5408-5454</td>
                  <td>순천대학교(조경학과)</td>
                </tr>
                <!--두 번째 줄 끝-->
              </table>
            </div>
          </div>
        </div>
      </div>
    </section>
    <!-- Services-->
    <section class = "content-section bg-primary text-white text-center"
             id = "services"
    >
      <div class = "container px-4 px-lg-5">
        <div class = "content-section-heading">
          <h3 class = "text-secondary mb-0">Services</h3>
          <h2 class = "mb-5">What We Offer</h2>
        </div>
        <div class = "row gx-4 gx-lg-5">
          <div class = "col-lg-3 col-md-6 mb-5 mb-lg-0">
            <span class = "service-icon rounded-circle mx-auto mb-3"><i class = "icon-screen-smartphone"></i></span>
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
        </div>
      </div>
    </section>
    <!-- Callout-->
    <section class = "callout">
      <div class = "container px-4 px-lg-5 text-center">
        <h2 class = "mx-auto mb-5">
          Welcome to
          <em>your</em>
          next website!
        </h2>
        <a class = "btn btn-primary btn-xl"
           href = "https://startbootstrap.com/theme/stylish-portfolio/"
        >Download Now!</a>
      </div>
    </section>
    <!-- Portfolio-->
    <section class = "content-section"
             id = "portfolio"
    >
      <div class = "container px-4 px-lg-5">
        <div class = "content-section-heading text-center">
          <h3 class = "text-secondary mb-0">Portfolio</h3>
          <h2 class = "mb-5">Recent Projects</h2>
        </div>
        <div class = "row gx-0">
          <div class = "col-lg-6">
            <a class = "portfolio-item"
               href = "#!"
            >
              <div class = "caption">
                <div class = "caption-content">
                  <div class = "h2">Stationary</div>
                  <p class = "mb-0">A yellow pencil with envelopes on a clean, blue backdrop!</p>
                </div>
              </div>
              <img class = "img-fluid"
                   src = "@/assets/img/portfolio-1.jpg"
                   alt = "..."
              />
            </a>
          </div>
          <div class = "col-lg-6">
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
          </div>
          <div class = "col-lg-6">
            <a class = "portfolio-item"
               href = "#!"
            >
              <div class = "caption">
                <div class = "caption-content">
                  <div class = "h2">Strawberries</div>
                  <p class = "mb-0">Strawberries are such a tasty snack, especially with a little sugar on top!</p>
                </div>
              </div>
              <img class = "img-fluid"
                   src = "@/assets/img/portfolio-3.jpg"
                   alt = "..."
              />
            </a>
          </div>
          <div class = "col-lg-6">
            <a class = "portfolio-item"
               href = "#!"
            >
              <div class = "caption">
                <div class = "caption-content">
                  <div class = "h2">Workspace</div>
                  <p class = "mb-0">A yellow workspace with some scissors, pencils, and other objects.</p>
                </div>
              </div>
              <img class = "img-fluid"
                   src = "@/assets/img/portfolio-4.jpg"
                   alt = "..."
              />
            </a>
          </div>
        </div>
      </div>
    </section>
    <!-- Call to Action-->
    <section class = "content-section bg-primary text-white">
      <div class = "container px-4 px-lg-5 text-center">
        <h2 class = "mb-4">The buttons below are impossible to resist...</h2>
        <a class = "btn btn-xl btn-light me-4"
           href = "#!"
        >Click Me!</a>
        <a class = "btn btn-xl btn-dark"
           href = "#!"
        >Look at Me!</a>
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
</style>