        var lokacija = 0;
        var trenutna = 0;
        function refresh(){
            pokazi(trenutna);
        }
        function folderDugme(){
            var Input = document.getElementById('nameInput').value;
            if (Input == ""){Input = "novi_Fajl";}
            dodajFolder(Input);
            pokazi(trenutna);
        }
        function dodajFolder(ime){
           const d = {
            parent: trenutna,
            name: ime,
            creation_time: new Date().toISOString()
           };

           axios.post("/api/folder", d)
           .then(response =>{
           console.log(response);
           })
           .then(error => {
           console.log(error);
           });
        }
        function brisiDugme(){
            var indeks =  document.getElementById("removeInput").value;
            var cat = document.getElementById("cat").value;
            obrisi(indeks,cat);
            pokazi(trenutna);
        }
        function obrisi(id, cat){
            axios.delete("/api/"+cat+"/"+id).then(response => {
                console.log(response);
            })
        }
        function nazad(){
            var lupatext =  document.getElementById("searchInput").value;
            pokazi(lokacija);

        }

        function traziLupa(){
            var id = 0;
            var lupatext =  document.getElementById("searchInput").value;

            if (lupatext!=""){
                id = lupatext;
            }
            console.log(lupatext);
            console.log(id);
            pokazi(id);
        }
        function fileDugme() {
            var ime =  document.getElementById("fileInput").value;
            var data = document.getElementById("dataInput").value;
            napraviFile(ime,data);
            refresh();
        }
        function napraviFile(ime, data){
           const d = {
            parent: trenutna,
            name: ime,
            creation_time: new Date().toISOString(),
            content: data
           };

           axios.post("/api/file", d)
           .then(response =>{
           console.log(response);
           })
           .then(error => {
           console.log(error);
           });
        }
       function pokazi(id){
               var main =  document.getElementById("main");
               var heading = document.getElementById("maintitle");
               main.innerText = "";
               heading.innerText = "";
               trenutna = id;
               axios.get("/api/folder/"+id).then(response => {
                  const dat = response.data;
                  lokacija = dat.parent;
                  heading.innerText = heading.innerText +
                  "FOLDER | "+
                  "NAME: "+ dat.name+
                  " | ID:  " + dat.folder_id+
                  " | PARENT ID: " + dat.parent+
                  " | CREATED AT:  " + dat.creation_time +
                  //"       --" + red+
                  "\n";
               })

                  axios.get("/api/file/s/"+id).then(response => {
                      const consts = response.data;
                      console.log(consts);

                      //addline(const.name);
                      for (const red in consts){
                          var main =  document.getElementById("main");
                          const newDiv = document.createElement("div");
                          const linebreak = document.createElement("br");
                          const newContent = document.createTextNode(consts.name);
                          //main.appendChild(linebreak);
                          //main.appendChild(newContent);
                           main.innerText = main.innerText +
                           "FILE        | "+
                           "  ID:  " + consts[red].file_id+
                           "       CREATED AT:  " + consts[red].creation_time +
                           "       NAME: "+ consts[red].name+
                           "           DATA:  " + consts[red].content +
                           //"       --" + red+
                           "\n\n";
                      }
                  })
                  for(var i = 0; i<1000000; i++){

                  }
                  axios.get("/api/folder/s/"+id).then(response => {
                      const consts = response.data;
                      console.log(consts);

                      //addline(const.name);
                      for (const red in consts){
                          var main =  document.getElementById("main");
                          const newDiv = document.createElement("div");
                          const linebreak = document.createElement("br");
                          const newContent = document.createTextNode(consts.name);
                          const newnewDiv = document.createElement("div");
                          //main.appendChild(linebreak);
                          //main.appendChild(newContent);
                           newnewDiv.textContent =
                           "FOLDER | "+
                           "  ID:  " + consts[red].folder_id+
                           "       CREATED AT:  " + consts[red].creation_time +
                           "       NAME: "+ consts[red].name+
                           //"       --" + red+
                           "\n\n";
                           //newnewDiv.onclick = "refresh()";
                           newnewDiv.onclick = function() {
                                pokazi(consts[red].folder_id);
                                //alert("test");
                           };
                           main.appendChild(newnewDiv);
                      }
                  })
              }
      /*  function doit(){
         var main =  document.getElementById("main");

          axios.get("/api/file/s/1").then(response => {
          const consts = response.data;
          console.log(consts);
          //addline(const.name);

              var main =  document.getElementById("main");
              const newDiv = document.createElement("div");
              const linebreak = document.createElement("br");
              const newContent = document.createTextNode(consts.name);
              //main.appendChild(linebreak);
              //main.appendChild(newContent);
               main.innerText = consts;
          })
        }*/