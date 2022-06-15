/*!
 * Start Bootstrap - Stylish Portfolio v6.0.5 (https://startbootstrap.com/theme/stylish-portfolio)
 * Copyright 2013-2022 Start Bootstrap
 * Licensed under MIT (https://github.com/StartBootstrap/startbootstrap-stylish-portfolio/blob/master/LICENSE)
 */

/*eslint-disable*/
function loadWin () {
  const sidebarWrapper = document.getElementById('sidebar-wrapper')
  let scrollToTopVisible = false
  // Closes the sidebar menu
  const menuToggle = document.body.querySelector('.menu-toggle')
  menuToggle.addEventListener('click', event => {
    event.preventDefault()
    sidebarWrapper.classList.toggle('active')
    _toggleMenuIcon()
    menuToggle.classList.toggle('active')
  })

  // Closes responsive menu when a scroll trigger link is clicked
  var scrollTriggerList = [].slice.call(
    document.querySelectorAll('#sidebar-wrapper .js-scroll-trigger'))
  scrollTriggerList.map(scrollTrigger => {
    scrollTrigger.addEventListener('click', () => {
      sidebarWrapper.classList.remove('active')
      menuToggle.classList.remove('active')
      _toggleMenuIcon()
    })
  })

  function _toggleMenuIcon () {
    const menuToggleBars = document.body.querySelector(
      '.menu-toggle > .fa-bars')
    const menuToggleTimes = document.body.querySelector(
      '.menu-toggle > .fa-xmark')
    if (menuToggleBars) {
      menuToggleBars.classList.remove('fa-bars')
      menuToggleBars.classList.add('fa-xmark')
    }
    if (menuToggleTimes) {
      menuToggleTimes.classList.remove('fa-xmark')
      menuToggleTimes.classList.add('fa-bars')
    }
  }

  // Scroll to top button appear
  document.addEventListener('scroll', () => {
    const scrollToTop = document.body.querySelector('.scroll-to-top')
    if (document.documentElement.scrollTop > 100) {
      if (!scrollToTopVisible) {
        fadeIn(scrollToTop)
        scrollToTopVisible = true
      }
    }
    else {
      if (scrollToTopVisible) {
        fadeOut(scrollToTop)
        scrollToTopVisible = false
      }
    }
  })

  // Toggle the side navigation
  const sidebarToggle = document.body.querySelector('#sidebarToggle')
  if (sidebarToggle) {
    // Uncomment Below to persist sidebar toggle between refreshes
    // if (localStorage.getItem('sb|sidebar-toggle') === 'true') {
    //     document.body.classList.toggle('sb-sidenav-toggled');
    // }
    sidebarToggle.addEventListener('click', event => {
      event.preventDefault()
      document.body.classList.toggle('sb-sidenav-toggled')
      localStorage.setItem('sb|sidebar-toggle',
        document.body.classList.contains('sb-sidenav-toggled'))
    })
  }
}

// window.addEventListener 끝부분
// => loadWin 펑션으로 변경

export default loadWin