$(document).ready(() => {
  let alertLabel = $(".alert");
  let alertStatus = alertLabel.attr('data-status');

  if (alertStatus) {
    alertLabel.addClass(alertStatus === "Success" ? 'alert-success' : 'alert-danger');
    setTimeout(() => alertLabel.css('opacity', '1'), 300);
    setTimeout(() => alertLabel.css('opacity', '0'), 3000);
  }
});