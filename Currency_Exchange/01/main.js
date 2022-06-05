// 3. 환율정보 들고오기
let currencyRatio = {
  USD: {
    KRW : 1_251.53,
    USD : 1,
    VND : 23_192.00,
    unit: '달러',
  },
  KRW: {
    KRW : 1,
    USD : 0.00080,
    VDN : 18.53,
    unit: '원',
  },
  VND: {
    KRW : 0.054,
    USD : 0.000043,
    VDN : 1,
    unit: '동',
  },
}

let fromCurrency = 'USD'
document.querySelectorAll('#from-currency-list a').
  forEach(menu => menu.addEventListener('click', function () {
    document.getElementById('from-button').textContent = this.textContent
    fromCurrency = this.textContent
    convert()
  }))

let toCurrency = 'USD'
document.querySelectorAll('#to-currency-list a').
  forEach(menu => menu.addEventListener('click', function () {
    document.getElementById('to-button').textContent = this.textContent
    toCurrency = this.textContent
    convert()
  }))

function convert () {
  let amount = document.getElementById('from-input').value
  let convertedAmout = amount * currencyRatio[fromCurrency][toCurrency]
  document.getElementById('to-input').value = convertedAmout;
}