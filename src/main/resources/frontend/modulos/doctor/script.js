const doctorForm = document.getElementById("doctorForm");
const doctoresList = document.getElementById("doctoresList");

doctorForm.addEventListener("submit", async (event) => {
  event.preventDefault();
  const nombre = document.getElementById("nombre").value;
  const apellido = document.getElementById("apellido").value;
  const especialidad = document.getElementById("especialidad").value;
  const consultorio = document.getElementById("consultorio").value;
  const correo = document.getElementById("correo").value;

  try {
    const response = await fetch("/api/doctores", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        nombre,
        apellido,
        especialidad,
        consultorio,
        correo,
      }),
    });

    if (response.ok) {
      const doctor = await response.json();
      const doctorItem = document.createElement("li");
      doctorItem.innerText = `Nombre: ${doctor.nombre}, Apellido: ${doctor.apellido}, Especialidad: ${doctor.especialidad}, Consultorio: ${doctor.consultorio}, Correo: ${doctor.correo}`;
      doctoresList.appendChild(doctorItem);
      doctorForm.reset();
    } else {
      alert("Error al guardar el doctor.");
    }
  } catch (error) {
    console.error("Error en la solicitud:", error);
    alert("Error al realizar la solicitud.");
  }
});
