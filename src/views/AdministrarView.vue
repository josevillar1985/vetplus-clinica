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

        <v-list-item link>
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
            Administrar citas
          </v-card-title>

          <v-text-field
            v-model="search"
            label="Buscar"
            prepend-inner-icon="mdi-magnify"
            outlined
            dense
            hide-details
            class="mb-4"
          />

          <v-data-table
            :headers="headers"
            :items="citas"
            :search="search"
            :items-per-page="5"
          >
            <template slot="item.acciones" slot-scope="props">
              <v-btn icon small color="primary" class="mr-2" @click="abrirEditar(props.item)">
                <v-icon>mdi-pencil</v-icon>
              </v-btn>

              <v-btn icon small color="red" @click="abrirEliminar(props.item)">
                <v-icon>mdi-delete</v-icon>
              </v-btn>
            </template>
          </v-data-table>
        </v-card>
      </v-container>
    </v-main>

    <v-dialog v-model="modalEditar" max-width="500">
      <v-card>
        <v-card-title>Editar cita</v-card-title>
        <v-card-text>
          <v-form>
            <v-text-field v-model="formulario.nombreCliente" label="Nombre" />
            <v-text-field v-model="formulario.dni" label="DNI" />
            <v-text-field v-model="formulario.nombreMascota" label="Mascota" />
            <v-date-picker v-model="formulario.fecha" color="success" :allowed-dates="fechaPermitida" width="100%" />
            <v-select v-model="formulario.hora" :items="horasDisponiblesEdicion" label="Hora" outlined dense class="mt-3" />
          </v-form>
        </v-card-text>
        <v-card-actions>
          <v-spacer />
          <v-btn text @click="modalEditar = false">Cancelar</v-btn>
          <v-btn color="success" @click="guardarEdicion">Guardar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <v-dialog v-model="modalEliminar" max-width="400">
      <v-card>
        <v-card-title>¿Eliminar cita?</v-card-title>
        <v-card-text>Esta acción no se puede deshacer</v-card-text>
        <v-card-actions>
          <v-spacer />
          <v-btn text @click="modalEliminar = false">Cancelar</v-btn>
          <v-btn color="red" @click="confirmarEliminar">Eliminar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-app>
</template>

<script>
import axios from 'axios'

// ✅ URL ACTUALIZADA: Usando el subdominio compatible con SSL de Cloudflare
const API_URL = 'https://api-vetplus.josevillar.com'

export default {
  name: 'AdministrarView',
  data () {
    return {
      search: '',
      citas: [],
      citaSeleccionada: null,
      modalEditar: false,
      modalEliminar: false,
      formulario: {
        id: null,
        nombreCliente: '',
        dni: '',
        nombreMascota: '',
        fecha: '',
        hora: ''
      },
      hoy: new Date().toISOString().split('T')[0],
      horasBase: ['10:00', '11:00', '12:00', '13:00', '14:00', '17:00', '18:00', '19:00', '20:00'],
      horasOcupadasFecha: [],
      headers: [
        { text: 'Nombre', value: 'nombreCliente' },
        { text: 'DNI', value: 'dni' },
        { text: 'Mascota', value: 'nombreMascota' },
        { text: 'Fecha', value: 'fecha' },
        { text: 'Hora', value: 'hora' },
        { text: 'Acciones', value: 'acciones', sortable: false }
      ]
    }
  },
  computed: {
    horasDisponiblesEdicion () {
      return this.horasBase.filter(h =>
        !this.horasOcupadasFecha.includes(h) || h === this.formulario.hora
      )
    }
  },
  mounted () {
    this.cargarCitas()
  },
  methods: {
    fechaPermitida (fecha) {
      return fecha >= this.hoy || fecha === this.formulario.fecha
    },
    cargarCitas () {
      axios.get(`${API_URL}/citas`)
        .then(res => (this.citas = res.data))
        .catch(() => (this.citas = []))
    },
    abrirEditar (cita) {
      this.formulario = { ...cita }
      this.modalEditar = true
      axios.get(`${API_URL}/citas/fecha`, { params: { fecha: cita.fecha } })
        .then(res => {
          this.horasOcupadasFecha = res.data
            .filter(c => c.id !== cita.id)
            .map(c => c.hora)
        })
        .catch(() => (this.horasOcupadasFecha = []))
    },
    guardarEdicion () {
      axios.put(`${API_URL}/citas/${this.formulario.id}`, this.formulario)
        .then(() => {
          this.modalEditar = false
          this.cargarCitas()
        })
    },
    abrirEliminar (cita) {
      this.citaSeleccionada = cita
      this.modalEliminar = true
    },
    confirmarEliminar () {
      axios.delete(`${API_URL}/citas/${this.citaSeleccionada.id}`)
        .then(() => {
          this.modalEliminar = false
          this.cargarCitas()
        })
    }
  }
}
</script>

<style>
html, body, #app { height: 100%; margin: 0; }
.drawer { background-color: #f5f5f5; }
</style>