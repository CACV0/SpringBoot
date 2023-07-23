const pacienteForm = document.getElementById("pacienteForm");
const pacientesList = document.getElementById("pacientesList");

pacienteForm.addEventListener("submit", async (event) => {
  event.preventDefault();
  const nombre = document.getElementById("nombre").value;
  const cedula = document.getElementById("cedula").value;
  const apellido = document.getElementById("apellido").value;
  const edad = document.getElementById("edad").value;
  const telefono = document.getElementById("telefono").value;

  try {
    const response = await fetch("/api/pacientes", {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify({
        nombre,
        cedula,
        apellido,
        edad,
        telefono,
      }),
    });

    if (response.ok) {
      const paciente = await response.json();
      const pacienteItem = document.createElement("li");
      pacienteItem.innerText = `Nombre: ${paciente.nombre}, Cédula: ${paciente.cedula}, Apellido: ${paciente.apellido}, Edad: ${paciente.edad}, Teléfono: ${paciente.telefono}`;
      pacientesList.appendChild(pacienteItem);
      pacienteForm.reset();
    } else {
      alert("Error al guardar el paciente.");
    }
  } catch (error) {
    console.error("Error en la solicitud:", error);
    alert("Error al realizar la solicitud.");
  }
});
