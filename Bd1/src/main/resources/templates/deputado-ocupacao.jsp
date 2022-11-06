<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-br"> 
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1"/>
        <meta name="author" content="João Paulo C. de Souza, Pedro W. Hernandes">
        <title>Trabalho de Banco de Dados</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@200;300;400;500;600;700&family=Nunito:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    </head>
    <body>
        <div class="header">
            <div>
                <div class="headerTitle">
                    <h1 class="title">
                        BD 2022 
                    </h1>
                    <h2 class="subtitle">
                        Ocupação deputado
                    </h2>
                </div>
                <div class="colorsHeader">
                    <div class="colorHeader" style="background-color: #ffdf00"></div>
                    <div class="colorHeader" style="background-color: #009c3b"></div>
                    <div class="colorHeader" style="background-color: #002776"></div>
                </div>
            </div>
            <div class="filter">
                <input type="text" class="filterInput" placeholder="Pesquisar...">
            </div>
        </div>
        <div class="subheader">
            <button class="btnSend">
                Enviar dados
            </button>
            <button class="btnSend">
                Deputados
            </button>
            <button class="btnSend">
                Órgãos
            </button>
        </div>
        <div class="body">
            <table class="table">
                <thead>
                  <tr>
                    <th scope="col">ID</th>
                    <th scope="col">Titulo</th>
                    <th scope="col">Entidade</th>
                    <th scope="col">Ano de inicio</th>
                    <th scope="col">Ano fim</th>
                    <th scope="col">UF</th>
                    <th scope="col">País</th>
                  </tr>
                </thead>
                <tbody>
                  <tr>
                    <tr th:each="DepOcup: ${DepOcupacao}">
                        <th th:text="${DepOcup.id_dep}" scope="row"></th>
                        <td th:text="${DepOcup.titulo}"></td>
                        <td th:text="${DepOcup.entidade}"></td>
                        <td th:text="${DepOcup.ano_ini}"></td>
                        <td th:text="${DepOcup.ano_fim}"></td>
                        <td th:text="${DepOcup.UF_ent}"></td>
                        <td th:text="${DepOcup.pais_entidade}"></td>
                      </tr>
                  </tr>
                </tbody>
              </table>
        </div>

        <div class="modal fade modal_excluir_usuario">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">Confirmação</h4>
                        <button class="close" type="button" data-dismiss="modal"><span>&times;</span></button>
                    </div>
                    <div class="modal-body">
                        <p>Tem certeza de que deseja excluir este usuário?</p>
                    </div>
                    <div class="modal-footer">
                        <a class="btn btn-danger link_confirmacao_excluir_usuario">Sim</a>
                        <button class="btn btn-primary" type="button" data-dismiss="modal">Não</button>
                    </div>
                </div>
            </div>
        </div>      
    </body>

    <footer>
        <script type="javascript">
            
        </script>
    </footer>

</html>
