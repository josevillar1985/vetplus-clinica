<template>
  <div>
    <HeaderComponent />
    

    <div class="hero-wrapper">
      <TituloHero />
      <CarouselComponent />
    </div>
    <EspecialidadesComponent />
    <v-divider class="mt-0 mb-16" thickness="2" color="#2e7d32" />
    <CardsComponent />
    <FooterComponent />
  </div>
  
    
  
</template>

<script>
import CardsComponent from '@/components/CardsComponent.vue';
import CarouselComponent from '@/components/CarouselComponent.vue'
import EspecialidadesComponent from '@/components/EspecialidadesComponent.vue'
import FooterComponent from '@/components/FooterComponent.vue';
import HeaderComponent from '@/components/HeaderComponent.vue'
import TituloHero from '@/components/TituloHero.vue'

export default {
  name: "HomeView",
  components: {
    HeaderComponent,
    CarouselComponent,
    TituloHero,
    EspecialidadesComponent,
    CardsComponent,
    FooterComponent
    
  }
}
</script>

<style scoped>
.hero-wrapper {
  position: relative;
  margin-top: 64px; /* altura típica del v-app-bar */
}

</style>
