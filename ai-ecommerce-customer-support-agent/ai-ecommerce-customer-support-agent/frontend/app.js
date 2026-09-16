const API="http://localhost:8080/api";
const products=document.getElementById("products"),search=document.getElementById("search");
const messages=document.getElementById("messages"),form=document.getElementById("form"),question=document.getElementById("question");
function add(text,type){const el=document.createElement("div");el.className=type;el.textContent=text;messages.appendChild(el);messages.scrollTop=messages.scrollHeight;}
function render(list){products.innerHTML="";if(!list.length){products.textContent="No products found.";return;}list.forEach(p=>{const el=document.createElement("article");el.className="product";el.innerHTML=`<img src="${p.image}" alt="${p.name}"><div><small>${p.category}</small><h4>${p.name}</h4><p>${p.description}</p><div class="price">₹${p.price.toLocaleString("en-IN")}</div></div>`;products.appendChild(el);});}
async function load(q=""){try{const url=q?`${API}/products/search?keyword=${encodeURIComponent(q)}`:`${API}/products`;const r=await fetch(url);render(await r.json());}catch(e){products.textContent="Start the Spring Boot backend first using mvn spring-boot:run.";}}
async function send(text){add(text,"user");try{const r=await fetch(`${API}/chat`,{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify({message:text})});const data=await r.json();add(data.reply,"bot");}catch(e){add("Backend connection failed. Start Spring Boot on port 8080.","bot");}}
search.addEventListener("input",e=>load(e.target.value.trim()));
form.addEventListener("submit",e=>{e.preventDefault();const t=question.value.trim();if(t){question.value="";send(t);}});
document.querySelectorAll("[data-q]").forEach(b=>b.addEventListener("click",()=>send(b.dataset.q)));
load();
