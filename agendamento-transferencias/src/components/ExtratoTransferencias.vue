<template>
    <div>
      <h2>Extrato de Transferências</h2>
      <table border="1">
        <thead>
          <tr>
            <th>Conta Origem</th>
            <th>Conta Destino</th>
            <th>Valor</th>
            <th>Taxa</th>
            <th>Data Agendamento</th>
            <th>Data Transferência</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="transfer in transfers" :key="transfer.id">
            <td>{{ transfer.contaOrigem }}</td>
            <td>{{ transfer.contaDestino }}</td>
            <td>{{ transfer.valor }}</td>
            <td>{{ transfer.taxa }}</td>
            <td>{{ transfer.dataAgendamento }}</td>
            <td>{{ transfer.dataTransferencia }}</td>
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
      };
    },
    async mounted() {
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
  };
  </script>
  
  <style scoped>
  h2 {
    text-align: center;
  }
  
  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 10px;
  }
  
  th, td {
    padding: 8px;
    text-align: left;
    border: 1px solid #ddd;
  }
  </style>
  