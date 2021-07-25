## HTTP Client

새로운 HTTP Client 는 Java 9 에 들어왔지만 Java 11 에 완전히 표준이 되었고
HTTP 1.1 과 HTTP 2 를 지원하게 되었다.

다음과 같이 HTTP Client 를 사용하는게 가능하다. 

````java
@Test
void httpClient_Test() throws IOException, InterruptedException {
    //given
    HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(20))
            .build();

    int port = 8080;
    HttpRequest httpRequest = HttpRequest.newBuilder()
            .GET()
            .uri(URI.create("http://localhost:" + port))
            .build();
    //when
    HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
    //then
    System.out.println(httpResponse);
}
````  

