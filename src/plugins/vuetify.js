import Vue from 'vue'
import Vuetify from 'vuetify'

Vue.use(Vuetify)

export default new Vuetify({
  theme: {
    themes: {
      light: {
        primary: '#1976D2', // azul Vuetify
        secondary: '#424242',
        accent: '#82B1FF'
      }
    }
  }
})

