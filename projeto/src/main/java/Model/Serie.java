package Model;

public class Serie {
	// Criando no programa os atributos do banco de dados!!!
		private Long cod_serie;
		private String nome_serie;
		private int ano_serie;
		private Long cod_tema;
		private String nome_tema;
		private Long cod_streaming;
		private String nome_streaming;
		// Getters e Setters, fazem a função de escrita e leitura!!!
		public Long getCod_serie() {
			return cod_serie;
		}
		public void setCod_serie(Long cod_serie) {
			this.cod_serie = cod_serie;
		}
		public String getNome_serie() {
			return nome_serie;
		}
		public void setNome_serie(String nome_serie) {
			this.nome_serie = nome_serie;
		}
		public int getAno_serie() {
			return ano_serie;
		}
		public void setAno_serie(int ano_serie) {
			this.ano_serie = ano_serie;
		}
		public Long getCod_tema() {
			return cod_tema;
		}
		public void setCod_tema(Long cod_tema) {
			this.cod_tema = cod_tema;
		}
		public String getNome_tema() {
			return nome_tema;
		}
		public void setNome_tema(String nome_tema) {
			this.nome_tema = nome_tema;
		}
		public Long getCod_streaming() {
			return cod_streaming;
		}
		public void setCod_streaming(Long cod_streaming) {
			this.cod_streaming = cod_streaming;
		}
		public String getNome_streaming() {
			return nome_streaming;
		}
		public void setNome_streaming(String streaming) {
			this.nome_streaming = streaming;
		}
		// Criando o toString
		@Override
		public String toString() {
			return "Serie [cod_serie=" + cod_serie + ", nome_serie=" + nome_serie + ", ano_serie=" + ano_serie
					+ ", nome_tema=" + nome_tema + ", nome_streaming=" + nome_streaming + "]";
		}
		
}
