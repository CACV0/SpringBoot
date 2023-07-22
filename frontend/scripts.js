// scripts.js

const baseURL = 'http://localhost:8080';

// Función para obtener y mostrar la lista de especialidades
async function mostrarEspecialidades() {
    const especialidadesDiv = document.getElementById('especialidades');
    try {
        const response = await fetch(`${baseURL}/especialidades`);
        const especialidades = await response.json();
        
        const especialidadesList = document.createElement('ul');
        especialidades.forEach(especialidad => {
            const li = document.createElement('li');
            li.textContent = especialidad.nombre;
            especialidadesList.appendChild(li);
        });

        especialidadesDiv.appendChild(especialidadesList);
    } catch (error) {
        console.error('Error al obtener las especialidades:', error);
    }
}

// Función para obtener y mostrar la lista de doctores
async function mostrarDoctores() {
    const doctoresDiv = document.getElementById('doctores');
    try {
        const response = await fetch(`${baseURL}/doctores`);
        const doctores = await response.json();
        
        const doctoresList = document.createElement('ul');
        doctores.forEach(doctor => {
            const li = document.createElement('li');
            li.textContent = `${doctor.nombre} ${doctor.apellido} - ${doctor.especialidad.nombre}`;
            doctoresList.appendChild(li);
        });

        doctoresDiv.appendChild(doctoresList);
    } catch (error) {
        console.error('Error al obtener los doctores:', error);
    }
}

// Función para obtener y mostrar la lista de pacientes
async function mostrarPacientes() {
    const pacientesDiv = document.getElementById('pacientes');
    try {
        const response = await fetch(`${baseURL}/pacientes`);
        const pacientes = await response.json();
        
        const pacientesList = document.createElement('ul');
        pacientes.forEach(paciente => {
            const li = document.createElement('li');
            li.textContent = `${paciente.nombre} ${paciente.apellido} - Cédula: ${paciente.cedula}`;
            pacientesList.appendChild(li);
        });

        pacientesDiv.appendChild(pacientesList);
    } catch (error) {
        console.error('Error al obtener los pacientes:', error);
    }
}

// Función para obtener y mostrar la lista de citas
async function mostrarCitas() {
    const citasDiv = document.getElementById('citas');
    try {
        const response = await fetch(`${baseURL}/citas`);
        const citas = await response.json();
        
        const citasList = document.createElement('ul');
        citas.forEach(cita => {
            const li = document.createElement('li');
            li.textContent = `Cita #${cita.id} - Paciente: ${cita.paciente.nombre} ${cita.paciente.apellido} - Doctor: ${cita.doctor.nombre} ${cita.doctor.apellido} - Especialidad: ${cita.especialidad.nombre}`;
            citasList.appendChild(li);
        });

        citasDiv.appendChild(citasList);
    } catch (error) {
        console.error('Error al obtener las citas:', error);
    }
}

// Llamamos a las funciones para mostrar los datos cuando la página se cargue
document.addEventListener('DOMContentLoaded', () => {
    mostrarEspecialidades();
    mostrarDoctores();
    mostrarPacientes();
    mostrarCitas();
});
