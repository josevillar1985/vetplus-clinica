<template>
  <v-app>

    <!-- HEADER -->
    <v-app-bar app color="success" dark elevation="2">
      <v-app-bar-title>Clínica · Gestión</v-app-bar-title>
    </v-app-bar>

    <!-- DRAWER -->
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

        <!-- NUEVO: RESERVAR CITA ADMIN -->
        <v-list-item link to="/admin/reservar">
          <v-list-item-icon>
            <v-icon>mdi-calendar-plus</v-icon>
          </v-list-item-icon>
          <v-list-item-content>
            <v-list-item-title>Reservar cita</v-list-item-title>
          </v-list-item-content>
        </v-list-item>

        <!-- GESTIÓN DE CITAS -->
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

    <!-- MAIN -->
    <v-main>
      <v-container fluid class="d-flex justify-center">

        <v-card
          class="pa-6"
          max-width="1100"
          width="100%"
          elevation="3"
        >

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
              <v-btn
                icon
                small
                color="primary"
                class="mr-2"
                @click="abrirEditar(props.item)"
              >
                <v-icon>mdi-pencil</v-icon>
              </v-btn>

              <v-btn
                icon
                small
                color="red"
                @click="abrirEliminar(props.item)"
              >
                <v-icon>mdi-delete</v-icon>
              </v-btn>
            </template>

          </v-data-table>

        </v-card>

      </v-container>
    </v-main>

    <!-- MODAL EDITAR -->
    <v-dialog v-model="modalEditar" max-width="500">
      <v-card>
        <v-card-title>Editar cita</v-card-title>

        <v-card-text>
          <v-form>
            <v-text-field v-model="formulario.nombreCliente" label="Nombre" />
            <v-text-field v-model="formulario.dni" label="DNI" />
            <v-text-field v-model="formulario.nombreMascota" label="Mascota" />
            <v-text-field v-model="formulario.fecha" label="Fecha" />
            <v-text-field v-model="formulario.hora" label="Hora" />
          </v-form>
        </v-card-text>

        <v-card-actions>
          <v-spacer />
          <v-btn text @click="modalEditar = false">Cancelar</v-btn>
          <v-btn color="success" @click="guardarEdicion">Guardar</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>

    <!-- MODAL ELIMINAR -->
    <v-dialog v-model="modalEliminar" max-width="400">
      <v-card>
        <v-card-title>¿Eliminar cita?</v-card-title>

        <v-card-text>
          Esta acción no se puede deshacer
        </v-card-text>

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

  mounted () {
    this.cargarCitas()
  },

  methods: {
    cargarCitas () {
      axios
        .get('http://localhost:8081/citas')
        .then(res => (this.citas = res.data))
    },

    abrirEditar (cita) {
      this.formulario = { ...cita }
      this.modalEditar = true
    },

    guardarEdicion () {
      axios
        .put(`http://localhost:8081/citas/${this.formulario.id}`, this.formulario)
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
      axios
        .delete(`http://localhost:8081/citas/${this.citaSeleccionada.id}`)
        .then(() => {
          this.modalEliminar = false
          this.cargarCitas()
        })
    }
  }
}
</script>

<style>
html,
body,
#app {
  height: 100%;
  margin: 0;
}

.drawer {
  background-color: #f5f5f5;
}
</style>
