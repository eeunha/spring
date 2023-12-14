package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	// 목록보기
	@SuppressWarnings("deprecation") // 경고 노란 선 제거
	@GetMapping(value = "/list.do")
	public String list(Model model, String type, String word, String word2, @RequestParam(defaultValue = "0") int slop) {

		if (type == null || type.equals("")) {
			// 전체 검색
			type = "match_all";
		}

		try {

			// 엘라스틱서치 연결 정보 객체
//			HttpHost host = new HttpHost("엘라스틱서치IP", "포트번호", "프로토콜");
			HttpHost host = new HttpHost("172.21.195.80", 9200, "http");

			RestClientBuilder builder = RestClient.builder(host);

			// client > 엘라스틱서치와 대화 객체
			RestHighLevelClient client = new RestHighLevelClient(builder);

			// 접근하려는 인덱스 참조 > spring 인덱스
			SearchRequest searchRequest = new SearchRequest("spring");

			SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(100); // 최대 100개의 결과물

			// *** 엘라스틱서치 검색 기능
			// GET spring/_search
			// {
			// "query": {
			// "match_all": {}
			// }
			// }

			if (type.equals("match_all")) {

				// match all
				searchSourceBuilder.query(QueryBuilders.matchAllQuery());

			} else if (type.equals("match_or")) {

				// match
				searchSourceBuilder.query(QueryBuilders.matchQuery("message", word));

			} else if (type.equals("match_and")) {

				// match + operator(and)
				searchSourceBuilder.query(QueryBuilders.matchQuery("message", word).operator(Operator.AND));

			} else if (type.equals("match_phrase")) {

				// match phrase
				if (slop == 0) {
					searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("message", word));
				} else {
					searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("message", word).slop(slop));
				}
				
			} else if (type.equals("match_bool")) {

				// match bool
				searchSourceBuilder.query(QueryBuilders.boolQuery()
						.must(QueryBuilders.matchQuery("message", word)).mustNot(QueryBuilders.matchQuery("message", word2)));
				
			} else if (type.equals("match_should")) {

				// match should
				searchSourceBuilder.query(QueryBuilders.boolQuery()
						.must(QueryBuilders.matchQuery("message", word))
						.should(QueryBuilders.matchQuery("message", word)));
				
			}
			

			searchRequest.source(searchSourceBuilder);

			// 실제 검색 요청
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

			SearchHits searchHits = searchResponse.getHits();

			for (SearchHit hit : searchHits) {

				System.out.println(hit);

			}

			// js가 SearchHits 처리 못함
			// SearchHits > (변환) > List<HashMap>

			List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

			for (SearchHit hit : searchHits) {
				// Document > HashMap
				Map<String, Object> map = hit.getSourceAsMap();
				map.put("id", hit.getId());
				map.put("score", hit.getScore());
				list.add(map);
			}

			model.addAttribute("list", list);
			model.addAttribute("word", word);
			model.addAttribute("type", type);
			model.addAttribute("slop", slop);

			// 사용 종료 > 엘라스틱서치 접속 종료
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
	public String addok(Model model, String id, String message) {

		try {

			// client 객체
			RestHighLevelClient client = new RestHighLevelClient(
					RestClient.builder(new HttpHost("172.21.195.80", 9200, "http")));

			/*
			 * PUT spring/_doc/11 { "message": "안녕하세요. 홍길동입니다." }
			 */

			String data = String.format("{ \"message\": \"%s\" }", message);

			IndexRequest indexRequest = new IndexRequest("spring").source(data, XContentType.JSON)
					.setRefreshPolicy("wait_for");

			indexRequest.id(id);

			// 실제로 엘라스틱서치에 데이터(도큐먼트)를 추가하기
			client.index(indexRequest, RequestOptions.DEFAULT);

			client.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "redirect:/list.do";
	}
}
