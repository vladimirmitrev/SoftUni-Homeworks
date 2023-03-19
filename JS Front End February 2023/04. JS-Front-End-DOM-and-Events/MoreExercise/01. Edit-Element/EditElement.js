function editElement(element, match, replacer) {

    let text = element.textContent;

    while(text.includes(match)){
        text = text.replace(match, replacer);
    }
    element.textContent = text;
}
// function editElement(element, match, replacer) {
//     const text = element.textContent;
//     const newText = text.replace(new RegExp(match, 'g'), replacer);
//     element.textContent = newText;
// }