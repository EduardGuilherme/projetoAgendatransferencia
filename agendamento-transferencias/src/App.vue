<template>
  <div id="app">
    <h1>Sistema de Agendamento de Transferências</h1>
    <AgendarTransferencia />
    <ExtratoTransferencias />
  </div>
</template>

<script>
import AgendarTransferencia from './components/AgendarTransferencia.vue';
import ExtratoTransferencias from './components/ExtratoTransferencias.vue';

export default {
  name: 'App',
  components: {
    AgendarTransferencia,
    ExtratoTransferencias
  }
}
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  padding: 20px;
}
</style>
