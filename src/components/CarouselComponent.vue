<template>
    <div>
        <v-carousel height="400" :interval="3000" cycle>
            <v-carousel-item v-for="(src, i) in items" :key="i" :src="src" transition="cross-scale"
                reverse-transition="cross-scale" cover />
        </v-carousel>
    </div>



</template>

<script setup>
const items = [
  'https://images.pexels.com/photos/4587996/pexels-photo-4587996.jpeg?auto=compress&cs=tinysrgb&w=1600',
  'https://images.pexels.com/photos/4588013/pexels-photo-4588013.jpeg?auto=compress&cs=tinysrgb&w=1600',
  'https://media.istockphoto.com/id/511375254/es/foto/perros-con-una-gran-sonrisa.jpg?s=612x612&w=0&k=20&c=jGHTaQ_3FnqFZn_t9ekbxWAB-3YRcgKkPHm1TRmiMdI=',
  'https://images.pexels.com/photos/617278/pexels-photo-617278.jpeg?auto=compress&cs=tinysrgb&w=1600',
  'https://images.pexels.com/photos/4588018/pexels-photo-4588018.jpeg?auto=compress&cs=tinysrgb&w=1600',
  'https://images.pexels.com/photos/374906/pexels-photo-374906.jpeg?auto=compress&cs=tinysrgb&w=1600',
  'https://media.istockphoto.com/id/1041987488/es/foto/lindo-perro-de-poner-su-cara-en-sus-rodillas-y-el-hombre-sonriente-de-las-manos-rascarse-el.jpg?s=612x612&w=0&k=20&c=_-QrG1QimtXPttueHgPSkhchwUcn8DNtEclUpV991Cg=',
  'https://hips.hearstapps.com/wdy.h-cdn.co/assets/17/39/1600x800/landscape-1506709524-cola-0247.jpg?resize=768:*'
]


</script>

<style>
.cross-scale-enter-active,
.cross-scale-leave-active {
    transition: .5s cubic-bezier(0.25, 0.8, 0.5, 1);
    transition-property: opacity, transform;
}

.cross-scale-leave-from,
.cross-scale-leave-to {
    position: absolute !important;
    top: 0;
    width: 100%;
}

.cross-scale-enter-from,
.cross-scale-leave-to {
    opacity: 0;
    transform: scale(0.9);
}

@media (prefers-reduced-motion: reduce) {

    .cross-scale-enter-from,
    .cross-scale-leave-to {
        transform: none;
    }
}
</style>
