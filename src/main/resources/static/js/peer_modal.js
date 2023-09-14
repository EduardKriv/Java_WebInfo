const table = document.getElementById('table-peer');
const input = document.getElementById('date-c8e1');
const name = document.getElementById('name-3e72');

table.addEventListener('click', (e) => {
  if (e.target.tagName !== 'BUTTON') return;
  const head = table.tHead.rows[0].cells
  const tr = e.target.closest('tr');

  if (e.target.dataset.type == 'edit') editRow(head, tr);
  if (e.target.dataset.type == 'delete') deleteRow(tr);
});

function editRow(head, tr) {
  const current = {};
  for (let i = 0; i < tr.cells.length - 2; i++) {
    current[head[i].innerText] = tr.cells[i].innerText
  }
  showModal(current)
}

function deleteRow(tr) {
   tr.remove();
}

function showModal(editData) {
    input.value = editData.birthday;
    name.value = editData.nickname;
  console.log(editData.birthday);
}

function getResult() {
    const promise = axios.get(`/peer/all_id`, {
        // params: {
        //     expr: value,
        //     x: x_value
        // }
    });
    alert("ALALAL");
    return promise.then((resp) => {
        return resp.data;
    });
}
alert("AGA");
const selectPeer = document.getElementById('selectPeer');

selectPeer.addEventListener('click', getResult);
