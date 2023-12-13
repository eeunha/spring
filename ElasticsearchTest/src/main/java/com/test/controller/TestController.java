package com.test.controller;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TestController {

	// 목록보기
	@SuppressWarnings("deprecation") // 경고 노란 선 제거
	@GetMapping(value = "/list.do")
	public String list(Model model) {

		try {

			// 엘라스틱서치 연결 정보 객체
//			HttpHost host = new HttpHost("엘라스틱서치IP", "포트번호", "프로토콜");
			HttpHost host = new HttpHost("172.21.195.80", 9200, "http");

			RestClientBuilder builder = RestClient.builder(host);

			// client > 엘라스틱서치와 대화 객체
			RestHighLevelClient client = new RestHighLevelClient(builder);

			// 접근하려는 인덱스 참조 > spring 인덱스
			SearchRequest searchRequest = new SearchRequest("spring");

			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(100);

			// *** 엘라스틱서치 검색 기능
			// GET spring/_search
			// {
			// "query": {
			// "match_all": {}
			// }
			// }
			searchSourceBuilder.query(QueryBuilders.matchAllQuery());

			searchRequest.source(searchSourceBuilder);

			
			//실제 검색 요청
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			
			SearchHits searchHits = searchResponse.getHits();
			
			for (SearchHit hit : searchHits) {
				System.out.println(hit);
			}
			
			//사용 종료 > 엘라스틱서치 접속 종료
			client.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "list";
	}

	// 추가하기(폼)
	@GetMapping(value = "/add.do")
	public String add(Model model) {

		return "add";
	}

	// 추가하기(처리)
	@PostMapping(value = "/addok.do")
	public String addok(Model model) {

		return "addok";
	}
}
