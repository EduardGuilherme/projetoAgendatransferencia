<template>
  <div>
    <h2>Agendar Transferência</h2>
    <form @submit.prevent="agendar">
      <div>
        <label>Conta de Origem:</label>
        <input v-model="transfer.contaOrigem" required placeholder="XXXXXXXXXX" />
      </div>
      <div>
        <label>Conta de Destino:</label>
        <input v-model="transfer.contaDestino" required placeholder="XXXXXXXXXX" />
      </div>
      <div>
        <label>Valor da Transferência:</label>
        <input type="number" v-model.number="transfer.valorTransferencia" required />
      </div>
      <div>
        <label>Data da Transferência:</label>
        <input type="date" v-model="transfer.dataTransferencia" required />
      </div>
      <button type="submit">Agendar</button>
    </form>
    <p v-if="mensagem" :class="{ erro: erro }">{{ mensagem }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'AgendarTransferencia',
  data() {
    return {
      transfer: {
        contaOrigem: '',
        contaDestino: '',
        valorTransferencia: null,
        dataTransferencia: ''
      },
      mensagem: '',
      erro: false
    }
  },
  methods: {
        async agendar() {
      try {
        await axios.post('http://localhost:8081/api/transferencias', this.transfer);
        this.mensagem = 'Transferência agendada com sucesso!';
        this.erro = false;
        // Limpa o formulário
        this.transfer = {
          contaOrigem: '',
          contaDestino: '',
          valorTransferencia: null,
          dataTransferencia: ''
        };
      } catch (error) {
        this.mensagem = error.response && error.response.data
          ? error.response.data
          : 'Erro ao agendar transferência.';
        this.erro = true;
      }
    }
  }
}
</script>

<style scoped>
.erro {
  color: red;
}
</style>
