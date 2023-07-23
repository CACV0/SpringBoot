const citaForm = document.getElementById("citaForm");
const citasList = document.getElementById("citasList");

citaForm.addEventListener("submit", async (event) => {
  event.preventDefault();
  // Aquí debes obtener los datos del formulario relacionados con las citas

  try {
    // Aquí debes enviar los datos del formulario al servidor y guardar la cita en la base de datos

    // Luego, puedes mostrar la cita en la lista de citas
    const citaItem = document.createElement("li");
    // Aquí coloca la información de la cita obtenida del formulario
    citasList.appendChild(citaItem);

    // Limpiar el formulario después de guardar
    citaForm.reset();
  } catch (error) {
    console.error("Error en la solicitud:", error);
    alert("Error al realizar la solicitud.");
  }
});
