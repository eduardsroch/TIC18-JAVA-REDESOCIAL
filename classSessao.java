class Sessao {
    private Usuario usuario;
    private Date inicio;
    private Date fim;

    public Sessao(Usuario usuario) {
        this.usuario = usuario;
        this.inicio = Calendar.getInstance().getTime();
        this.fim = null;
        usuario.adicionarSessao(this);
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public static Sessao autenticar(ArrayList<Usuario> listaUsuarios, String nome, String senha) throws Exception {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNome().equals(nome) && usuario.getSenha().equals(senha)) {
                return new Sessao(usuario);
            }
        }
        throw new Exception("Usuário ou senha inválidos");
    }

    public void criarAmizade(Usuario amigo) {
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
            amigo.add(this);
            System.out.println(this.nome + " e " + amigo.getNome() + " são agora amigos.");
        } else {
            System.out.println(this.nome + " e " + amigo.getNome() + " já são amigos.");
        }
    }

    public void desfazerAmizade(Usuario exAmigo) {
        if (amigos.contains(exAmigo)) {
            amigos.remove(exAmigo);
            exAmigo.remove(this);
            System.out.println(this.nome + " e " + exAmigo.getNome() + " não são mais amigos.");
        } else {
            System.out.println(this.nome + " e " + exAmigo.getNome() + " não eram amigos.");
        }
    }

    public void incluirPostagem(String postagem) {
        listaPostagens.add(postagem);
        System.out.println("Postagem adicionada por " + this.nome + ": " + postagem);
    }

    public ArrayList<String> listarPostagens() {
        return usuario.listarPostagens();
    }

    private Usuario encontrarUsuario(String nomeUsuario, ArrayList<Usuario> listaUsuarios) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.getNome().equals(nomeUsuario)) {
                return usuario;
            }
        }
        return null;
    }
}

class Usuario {
    private String nome;
    private String email;
    private String senha;
    private ArrayList<Usuario> amigos;
    private ArrayList<String> listaPostagens;

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.amigos = new ArrayList<>();
        this.listaPostagens = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public void adicionarSessao(Sessao sessao) {
  
    }

    public void criarAmizade(Usuario amigo) {
        if (!amigos.contains(amigo)) {
            amigos.add(amigo);
            amigo.amigos.add(this);
            System.out.println(this.nome + " e " + amigo.getNome() + " são agora amigos.");
        } else {
            System.out.println(this.nome + " e " + amigo.getNome() + " já são amigos.");
        }
    }

    public void desfazerAmizade(Usuario exAmigo) {
        if (amigos.contains(exAmigo)) {
            amigos.remove(exAmigo);
            exAmigo.amigos.remove(this);
            System.out.println(this.nome + " e " + exAmigo.getNome() + " não são mais amigos.");
        } else {
            System.out.println(this.nome + " e " + exAmigo.getNome() + " não eram amigos.");
        }
    }

    public void incluirPostagem(String postagem) {
        listaPostagens.add(postagem);
        System.out.println("Postagem adicionada por " + this.nome + ": " + postagem);
    }

    public ArrayList<String> listarPostagens() {
        return listaPostagens;
    }
}

class Sistema {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Usuario user1 = new Usuario("Alice", "alice@email.com", "senha123");
        Usuario user2 = new Usuario("Bob", "bob@email.com", "senha456");
        usuarios.add(user1);
        usuarios.add(user2);

        try {
            Sessao sessao = Sessao.autenticar(usuarios, "Alice", "senha123");
            sessao.criarAmizade("Bob", usuarios);
            sessao.incluirPostagem("Olá, mundo!");
            sessao.desfazerAmizade("Bob", usuarios);
        } catch (Exception e) {
            System.out.println("Erro ao autenticar: " + e.getMessage());
        }
    }
}
