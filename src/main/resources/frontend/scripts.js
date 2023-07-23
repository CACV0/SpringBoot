const contentDiv = document.getElementById("content");

// Funciones para cargar los módulos en el div de contenido
function loadPacienteModule() {
  fetch("./modulos/paciente/paciente.html")
    .then((response) => response.text())
    .then((data) => {
      contentDiv.innerHTML = data;
    })
    .catch((error) =>
      console.error("Error al cargar el módulo paciente:", error)
    );
}

function loadDoctorModule() {
  fetch("./modulos/doctor/doctor.html")
    .then((response) => response.text())
    .then((data) => {
      contentDiv.innerHTML = data;
    })
    .catch((error) =>
      console.error("Error al cargar el módulo doctor:", error)
    );
}

function loadCitaModule() {
  fetch("./modulos/cita/cita.html")
    .then((response) => response.text())
    .then((data) => {
      contentDiv.innerHTML = data;
    })
    .catch((error) => console.error("Error al cargar el módulo cita:", error));
}

// Capturar los botones y asignar event listeners
const btnPaciente = document.getElementById("btnPaciente");
const btnDoctor = document.getElementById("btnDoctor");
const btnCita = document.getElementById("btnCita");

btnPaciente.addEventListener("click", loadPacienteModule);
btnDoctor.addEventListener("click", loadDoctorModule);
btnCita.addEventListener("click", loadCitaModule);
