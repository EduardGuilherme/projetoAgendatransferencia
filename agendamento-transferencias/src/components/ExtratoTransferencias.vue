<template>
    <div>
      <h2>Extrato de Transferências</h2>
      <table border="1">
        <thead>
          <tr>
            <th>ID</th>
            <th>Conta Origem</th>
            <th>Conta Destino</th>
            <th>Valor</th>
            <th>Taxa</th>
            <th>Data Agendamento</th>
            <th>Data Transferência</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="item in transfers" :key="item.id">
            <td>{{ item.id }}</td>
            <td>{{ item.contaOrigem }}</td>
            <td>{{ item.contaDestino }}</td>
            <td>{{ item.valorTransferencia }}</td>
            <td>{{ item.taxa }}</td>
            <td>{{ item.dataAgendamento }}</td>
            <td>{{ item.dataTransferencia }}</td>
          </tr>
        </tbody>
      </table>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: 'ExtratoTransferencias',
    data() {
      return {
        transfers: []
      }
    },
    async created() {
      await this.buscarTransferencias();
    },
    methods: {
      async buscarTransferencias() {
        try {
          const response = await axios.get('http://localhost:8081/api/transferencias');
          this.transfers = response.data;
        } catch (error) {
          console.error('Erro ao buscar transferências:', error);
        }
      }
    }
  }
  </script>
  