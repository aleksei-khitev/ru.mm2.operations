/*
 * ru.mm2.operations is an application for consultations and operations managing.
 * Copyright (c) 2014 Aleksei Khitevi (Хитёв Алексей Юрьевич), Guilnara Gamidova (Гюльнара Гамидова Вилаятовна).
 *
 * This file is part of ru.mm2.operations
 *
 * ru.mm2.operations is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * ru.mm2.operations is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Foobar.  If not, see <http://www.gnu.org/licenses/>.
*/

package ru.mm2.operations

import org.springframework.security.access.annotation.Secured

class SearchController {

    @Secured(['ROLE_OPER','ROLE_ROOT'])
    def index() {
        def query = params.q
        if (!query) {
            return [:]
        }
        try {
            def genOperSearchResult = GenOperationRecord.search(query, params)
            def comOperSearchResult = ComOperationRecord.search(query, params)
            def consSearchResult = ConsultationRecord.search(query, params)
            def comConsSearchResult = ComConsultationRecord.search(query, params)
            def comResearchSearchResult = ComResearchRecord.search(query, params)
            def doctorSearchResult = Doctor.search(query, params)
            def researchSearchResult = Research.search(query, params)
            return [doctorSearchResult: doctorSearchResult, genOperSearchResult: genOperSearchResult,comOperSearchResult: comOperSearchResult, consSearchResult: consSearchResult, comConsSearchResult: comConsSearchResult, comResearchSearchResult: comResearchSearchResult]
        } catch (e) {
            return [searchError: true]
        }
    }

}
