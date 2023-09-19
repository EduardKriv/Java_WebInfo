const table = document.getElementById('table-peer');

table.addEventListener('click', (e) => {
    if (e.target.tagName !== 'IMG') return;

    const tr = e.target.closest('tr');
    const entityId= document.getElementById(e.target.dataset.type);
    entityId.value = tr.cells[1].innerText;
});