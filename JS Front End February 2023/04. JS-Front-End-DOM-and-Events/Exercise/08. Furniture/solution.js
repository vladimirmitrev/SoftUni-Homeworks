function solve() {

  const [ generateTextArea, buyTextArea ] = Array.from(document.getElementsByTagName('textarea'));
  const [generateBtn, buyBtn ] = Array.from(document.getElementsByTagName('button'));
  const tbody = document.querySelector('.table > tbody');
  
  generateBtn.addEventListener('click', generateHandler);
  buyBtn.addEventListener('click', buyHandler);

  function generateHandler() {
    const data = JSON.parse(generateTextArea.value);
    for (const { img, name, price, decFactor, inputBox } of data) {

      const tableRow = createElementFunction('tr', '', tbody);
      const firstColumnTd = createElementFunction('td', '', tableRow);
      createElementFunction('img', '', firstColumnTd, '', '', { src: img });
      const secondColumnTd = createElementFunction('td', '', tableRow);
      createElementFunction('p', name, secondColumnTd);
      const thirdColumnTd = createElementFunction('td', '', tableRow);
      createElementFunction('p', price, thirdColumnTd);
      const fourthColumnTd = createElementFunction('td', '', tableRow);
      createElementFunction('p', decFactor,fourthColumnTd);
      const fifthColumnTd = createElementFunction('td', '', tableRow);
      createElementFunction('input', inputBox, fifthColumnTd, '', '', {type: 'checkbox'});
    } 
  }

  function buyHandler() {
     const allCheckedInputs = Array.from(document.querySelectorAll('tbody tr input:checked'));
      let boughtItems = [];
      let totalPrice = 0;
      let totalDecFactor = 0;

     for (const input of allCheckedInputs) {
          const tableRow =  input.parentElement.parentElement;
          const [ _firstColumn, secondColumnTd, thirdColumnTd, fourthColumnTd] = Array.from(tableRow.children);
          let item = secondColumnTd.children[0].textContent;
          boughtItems.push(item);
          let currentPrice = Number(thirdColumnTd.children[0].textContent);
          totalPrice += currentPrice;
          let currentDecFactor = Number(fourthColumnTd.children[0].textContent);
          totalDecFactor += currentDecFactor;
     }

     buyTextArea.value += `Bought furniture: ${boughtItems.join(', ')}\n`;
     buyTextArea.value += `Total price: ${totalPrice.toFixed(2)}\n`;
     buyTextArea.value += `Average decoration factor: ${totalDecFactor / allCheckedInputs.length}`;

        
  }

   //type - string
  //content - string
  //id - string
  //classes - array []
  //attributes - object {}
  function createElementFunction(type, content, parentNode, id, classes, attributes) {
    
    const htmlElement = document.createElement(type);

    if (content && type !== "input") {
      htmlElement.textContent = content;
    }

    if (content && type === "input") {
      htmlElement.value = content;
    }

    if (id) {
      htmlElement.id = id;
    }
    // ['list', 'item']
    if (classes) {
      htmlElement.classList.add(...classes);
    }

    // { src: "link to image" , href: "link to site", type: "checkbox"}
    if (attributes) {
      for (const key in attributes) {
        htmlElement.setAttribute(key, attributes[key]);
      }
    }

    if (parentNode) {
      parentNode.appendChild(htmlElement);
    }

    return htmlElement;
  }
}