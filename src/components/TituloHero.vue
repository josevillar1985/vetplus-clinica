<template>
  <div class="hero-title">
    <span class="hero-badge">Clínica veterinaria</span>

    <h1>
      Cuida la salud<br />
      de tu mascota
    </h1>

    <p class="hero-text">
      Atención veterinaria cercana, profesional y de confianza
    </p>
  </div>
</template>

<script>
export default {
  name: "TituloHero"
}
</script>

<style scoped>
.hero-title {
  position: absolute;
  top: 50%;
  left: 48px;
  transform: translateY(-50%);
  z-index: 10;

  max-width: 520px;
  color: white;
}

.hero-badge {
  display: inline-block;
  margin-bottom: 12px;
  padding: 6px 14px;

  font-size: 0.85rem;
  font-weight: 600;
  letter-spacing: 0.5px;

  color: #e8f5e9;
  background: rgba(46, 125, 50, 0.9);
  border-radius: 20px;
}

.hero-title h1 {
  font-size: 3.2rem;
  font-weight: 800;
  line-height: 1.1;
  margin-bottom: 16px;
}

.hero-title p {
  font-size: 1.25rem;
  line-height: 1.5;
  opacity: 0.95;
}
</style>
