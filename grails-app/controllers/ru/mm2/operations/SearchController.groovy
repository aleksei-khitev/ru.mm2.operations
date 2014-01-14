package ru.mm2.operations

class SearchController {

    def index = {
        def query = params.q
        if (!query) {
            return [:]
        }
        try {
            def operSearchResult = OperationRecord.search(query, params)
            def comOperSearchResult = ComOperationRecord.search(query, params)
            def consSearchResult = ConsultationRecord.search(query, params)
            def comConsSearchResult = ComConsultationRecord.search(query, params)
            def comResearchSearchResult = ComResearchRecord.search(query, params)
            def doctorSearchResult = Doctor.search(query, params)
            def researchSearchResult = Research.search(query, params)
            return [doctorSearchResult: doctorSearchResult, operSearchResult: operSearchResult,comOperSearchResult: comOperSearchResult, consSearchResult: consSearchResult, comConsSearchResult: comConsSearchResult, comResearchSearchResult: comResearchSearchResult]
        } catch (e) {
            return [searchError: true]
        }
    }

}
