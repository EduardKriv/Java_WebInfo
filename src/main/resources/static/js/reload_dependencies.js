let selectiveOptions = [
  document.querySelectorAll('.peer-select'),
  document.querySelectorAll('.task-select'),
  document.querySelectorAll('.check-select')
];

let urls = [
  '/peer/all_id',
  '/task/all_id',
  '/check/all_id'
];

let requests = urls.map(url => fetch(url));

function setOptions(selectors, data) {
  selectors.forEach(element => {
    data.forEach((option, key) => {
      element[key] = new Option(option, option, false, false);
    });
  });
}

function reloadDependencies() {
  axios.all(urls.map((endpoint) => axios.get(endpoint))).then((resps) => {
    resps.forEach((resp, i) => {
      setOptions(selectiveOptions[i], resp.data);
    })
  });
}

reloadDependencies();