<template>
  <v-app>

    <v-app-bar app color="success" dark elevation="2">
      <v-app-bar-title>Clínica · Gestión</v-app-bar-title>
    </v-app-bar>

    <v-navigation-drawer app permanent class="drawer">
      <v-list dense>

        <v-list-item link to="/">
          <v-list-item-icon>
            <v-icon>mdi-arrow-left</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Volver</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-divider class="my-2" />

        <v-list-item link to="/admin/reservar">
          <v-list-item-icon>
            <v-icon>mdi-calendar-plus</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Reservar cita</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <v-list-item link to="/administrar">
          <v-list-item-icon>
            <v-icon>mdi-calendar</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Gestión de citas</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

      </v-list>
    </v-navigation-drawer>

    <v-main>
      <v-container fluid class="d-flex justify-center">

        <v-card class="pa-6" max-width="1100" width="100%" elevation="3">
          <v-card-title class="text-h6 mb-4">
            Reservar cita
          </v-card-title>

          <v-row justify="center">
            <v-col cols="12" class="d-flex justify-center">
              <v-date-picker
                v-model="formulario.fecha"
                width="500"
                color="success"
                :first-day-of-week="1"
                :allowed-dates="fechaPermitida"
              />
            </v-col>
          </v-row>

          <section class="seccion-horario mt-4">
            <p class="turno-titulo">Mañana</p>
            <div class="horas-grid">
              <v-btn
                v-for="hora in horasManana"
                :key="hora"
                small
                :color="colorHora(hora)"
                :disabled="!horaDisponible(hora)"
                class="hora-btn"
                @click="seleccionarHora(hora)"
              >
                {{ hora }}
              </v-btn>
            </div>

            <p class="turno-titulo mt-4">Tarde</p>
            <div class="horas-grid">
              <v-btn
                v-for="hora in horasTarde"
                :key="hora"
                small
                :color="colorHora(hora)"
                :disabled="!horaDisponible(hora)"
                class="hora-btn"
                @click="seleccionarHora(hora)"
              >
                {{ hora }}
              </v-btn>
            </div>
          </section>

          <v-form class="mt-6">
            <v-row>
              <v-col cols="12" md="6">
                <v-text-field
                  v-model="formulario.nombreCliente"
                  label="Nombre del cliente"
                />
              </v-col>

              <v-col cols="12" md="6">
                <v-text-field
                  v-model="formulario.dni"
                  label="DNI"
                />
              </v-col>

              <v-col cols="12" md="6">
                <v-text-field
                  v-model="formulario.nombreMascota"
                  label="Nombre de la mascota"
                />
              </v-col>
            </v-row>

            <v-btn
              color="primary"
              large
              class="mt-4"
              :disabled="!formulario.fecha || !formulario.hora"
              @click="guardarCita"
            >
              Guardar cita
            </v-btn>
          </v-form>

        </v-card>

      </v-container>
    </v-main>

  </v-app>
</template>

<script>
import axios from 'axios'
import Swal from 'sweetalert2'

// ✅ URL ACTUALIZADA: Usando HTTPS y el subdominio con guion compatible con Cloudflare
const API_URL = 'https://api-vetplus.josevillar.com'

export default {
  name: 'ReservarCitaAdmin',

  data () {
    return {
      horasManana: ['10:00', '11:00', '12:00', '13:00', '14:00'],
      horasTarde: ['17:00', '18:00', '19:00', '20:00'],
      horasNoDisponibles: [],
      horaSeleccionada: null,

      formulario: {
        fecha: '',
        hora: '',
        nombreCliente: '',
        dni: '',
        nombreMascota: ''
      },

      hoy: new Date().toISOString().split('T')[0]
    }
  },

  methods: {
    fechaPermitida (fecha) {
      return fecha >= this.hoy
    },

    seleccionarHora (hora) {
      if (!this.horaDisponible(hora)) return
      this.horaSeleccionada = hora
      this.formulario.hora = hora
    },

    horaDisponible (hora) {
      return !this.horasNoDisponibles.includes(hora)
    },

    colorHora (hora) {
      if (!this.horaDisponible(hora)) return 'error'
      if (hora === this.horaSeleccionada) return 'primary'
      return 'success'
    },

    guardarCita () {
      axios.post(`${API_URL}/citas`, this.formulario)
        .then(() => {
          Swal.fire({
            icon: 'success',
            title: 'Cita registrada',
            text: 'La cita se ha guardado correctamente',
            confirmButtonColor: '#2e7d32'
          })

          this.horaSeleccionada = null
          this.formulario = {
            fecha: '',
            hora: '',
            nombreCliente: '',
            dni: '',
            nombreMascota: ''
          }
          this.horasNoDisponibles = []
        })
        .catch(error => {
          const mensaje =
            error.response && typeof error.response.data === 'string'
              ? error.response.data
              : 'Error al guardar la cita'

          Swal.fire({
            icon: 'error',
            title: 'No se pudo guardar',
            text: mensaje,
            confirmButtonColor: '#c62828'
          })
        })
    }
  },

  watch: {
    'formulario.fecha' (nuevaFecha) {
      if (!nuevaFecha) return

      // Manejo de objeto Date si el componente lo devuelve así
      if (nuevaFecha instanceof Date) {
        const y = nuevaFecha.getFullYear()
        const m = String(nuevaFecha.getMonth() + 1).padStart(2, '0')
        const d = String(nuevaFecha.getDate()).padStart(2, '0')
        this.formulario.fecha = `${y}-${m}-${d}`
        return
      }

      this.horaSeleccionada = null
      this.formulario.hora = ''

      axios.get(`${API_URL}/citas/fecha`, {
        params: { fecha: nuevaFecha }
      })
        .then(res => {
          this.horasNoDisponibles = [
            ...new Set(res.data.map(c => c.hora))
          ]
        })
        .catch(() => {
          this.horasNoDisponibles = []
        })
    }
  }
}
</script>

<style scoped>
.drawer {
  background-color: #f5f5f5;
}

.seccion-horario {
  text-align: center;
}

.turno-titulo {
  font-weight: 600;
  margin-bottom: 6px;
}

.horas-grid {
  display: flex;
  justify-content: center;
  flex-wrap: wrap;
  gap: 10px;
}

.hora-btn {
  min-width: 80px;
  font-weight: 600;
}
</style>