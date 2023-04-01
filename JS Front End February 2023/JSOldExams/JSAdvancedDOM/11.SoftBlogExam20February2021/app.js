function solve() {

   const nameInput = document.getElementById("creator");
   const titleInput = document.getElementById("title");
   const categoryInput = document.getElementById("category");
   const contentInput = document.getElementById("content");
   const createBtn = document.querySelector(".create");
   const sectionContainer = document.querySelector(".site-content > main > section");

   let archiveElements = [];

   console.log(sectionContainer);
 
   createBtn.addEventListener("click", createTaskHandler);
   function createTaskHandler(event) {
     event.preventDefault();
 
     let name = nameInput.value;
     let title = titleInput.value;
     let category = categoryInput.value;
     let content = contentInput.value;
 
     const articleEl = createEl("article", "", sectionContainer);
     createEl("h1", `${title}`, articleEl);
 
     const categoryParagraph = createEl("p", "Category:", articleEl);
     createEl("strong", `${category}`, categoryParagraph);
 
     const creatorParagraph = createEl("p", "Creator:", articleEl);
     createEl("strong", `${name}`, creatorParagraph);
 
     createEl("p", `${content}`, articleEl);
 
     const buttonsDiv = createEl("div", "", articleEl, ["buttons"]);
 
     const deleteBtn = createEl("button", "Delete", buttonsDiv, ["btn", "delete"]);
     const archiveBtn = createEl("button", "Archive", buttonsDiv, [
       "btn",
       "archive",
     ]);
 
     nameInput.value = "";
     titleInput.value = "";
     categoryInput.value = "";
     contentInput.value = "";
 
     archiveBtn.addEventListener("click", archiveTaskHandler);
 
     deleteBtn.addEventListener("click", deleteTaskHandler);
 
     function archiveTaskHandler(event) {
       
        event.currentTarget.parentNode.parentNode.remove();
       // articleEl.remove();
 
       archiveElements.push(title);
       let sorted = archiveElements.sort();
 
       const archive = document.querySelector(".archive-section > ol");
 
       archive.innerHTML = '';
 
       for (const el of sorted) {
          createEl("li", `${el}`, archive)
       }
     }
 
     function deleteTaskHandler(event) {
 
       event.currentTarget.parentNode.parentNode.remove();
       // articleEl.remove();
     }
   }
 
   function createEl(type, text, parent, classes) {
     let element = document.createElement(type);
 
     if (text) {
       element.textContent = text;
     }
     if (parent) {
       parent.appendChild(element);
     }
 
     if (classes) {
       element.classList.add(...classes);
     }
     return element;
   }
 }
 