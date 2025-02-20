<template>
  <div id="app">
    <h1>Sistema de Agendamento de Transferências</h1>
    <AgendarTransferencia @transferenciaCriada="atualizarExtrato" />
    <ExtratoTransferencias ref="extrato" />
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
  },
  methods: {
    atualizarExtrato() {
      this.$refs.extrato.buscarTransferencias();
    }
  }
}
</script>

<style>
#app {
  font-family: Arial, sans-serif;
  padding: 20px;
}
</style>
