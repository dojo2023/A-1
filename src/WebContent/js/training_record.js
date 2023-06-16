//ボタン再誕の儀
const form = document.getElementById("form");
const button = document.getElementById("button");

form.addEventListener("input", update);
form.addEventListener("change", update);
function update() {
  const isRequired = form.checkValidity();

  if (isRequired) {
    button.disabled = false;
    return;
  }
}

//フォーム増加の儀
function addExample() {
    let elements = document.getElementById("target");
    let copied = elements.lastElementChild.cloneNode(true);
    elements.appendChild(copied);
}
const btn = document.getElementById("button");
btn.addEventListener("click", addExample, false);

