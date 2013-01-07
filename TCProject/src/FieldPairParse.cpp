#include <cmath>
#include <ctime>
#include <iostream>
#include <cstring>
#include <vector>
#include <map>
#include <set>
#include <algorithm>
#include <cstdio>
#include <map>

using namespace std;

class FieldPairParse {
public:
   vector <int> getPairs( vector <string> data ) {
        vector <int> res;
   }
};

// BEGIN CUT HERE
namespace moj_harness {
	int run_test_case(int);
	void run_test(int casenum = -1, bool quiet = false) {
		if (casenum != -1) {
			if (run_test_case(casenum) == -1 && !quiet) {
				cerr << "Illegal input! Test case " << casenum << " does not exist." << endl;
			}
			return;
		}
		
		int correct = 0, total = 0;
		for (int i=0;; ++i) {
			int x = run_test_case(i);
			if (x == -1) {
				if (i >= 100) break;
				continue;
			}
			correct += x;
			++total;
		}
		
		if (total == 0) {
			cerr << "No test cases run." << endl;
		} else if (correct < total) {
			cerr << "Some cases FAILED (passed " << correct << " of " << total << ")." << endl;
		} else {
			cerr << "All " << total << " tests passed!" << endl;
		}
	}
	
	template<typename T> ostream& operator<<(ostream &os, const vector<T> &v) { os << "{"; for (typename vector<T>::const_iterator vi=v.begin(); vi!=v.end(); ++vi) { if (vi != v.begin()) os << ","; os << " " << *vi; } os << " }"; return os; }

	int verify_case(int casenum, const vector <int> &expected, const vector <int> &received, clock_t elapsed) { 
		cerr << "Example " << casenum << "... "; 
		
		string verdict;
		vector<string> info;
		char buf[100];
		
		if (elapsed > CLOCKS_PER_SEC / 200) {
			sprintf(buf, "time %.2fs", elapsed * (1.0/CLOCKS_PER_SEC));
			info.push_back(buf);
		}
		
		if (expected == received) {
			verdict = "PASSED";
		} else {
			verdict = "FAILED";
		}
		
		cerr << verdict;
		if (!info.empty()) {
			cerr << " (";
			for (int i=0; i<(int)info.size(); ++i) {
				if (i > 0) cerr << ", ";
				cerr << info[i];
			}
			cerr << ")";
		}
		cerr << endl;
		
		if (verdict == "FAILED") {
			cerr << "    Expected: " << expected << endl; 
			cerr << "    Received: " << received << endl; 
		}
		
		return verdict == "PASSED";
	}

	int run_test_case(int casenum__) {
		switch (casenum__) {
		case 0: {
			string data[]             = {
"XXXXX    XXXXX",
"XXXX    XXXXX "
};
			int expected__[]          = {3 };

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}
		case 1: {
			string data[]             = {
"XXXXXXXXXX     XXXXXXXXXXX",
"XXXXXXXXXXXXXXXXX    XXXXX"
};
			int expected__[]          = { };

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}
		case 2: {
			string data[]             = {
"X X X",
"X X X"
};
			int expected__[]          = { };

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}
		case 3: {
			string data[]             = {
"XXXX      X  X           X X   X",
"XX       XXX XX   X   X   X XXX "
};
			int expected__[]          = {5, 1, 3, 3, 2 };

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}
		case 4: {
			string data[]             = {"XXXX      X  X           X X   X"};
			int expected__[]          = {6, 2, 11, 1, 3 };

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}
		case 5: {
			string data[]             = {"XXX XXX XXX XXX XXX"};
			int expected__[]          = { };

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}

		// custom cases

/*      case 6: {
			string data[]             = ;
			int expected__[]          = ;

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}*/
/*      case 7: {
			string data[]             = ;
			int expected__[]          = ;

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}*/
/*      case 8: {
			string data[]             = ;
			int expected__[]          = ;

			clock_t start__           = clock();
			vector <int> received__   = FieldPairParse().getPairs(vector <string>(data, data + (sizeof data / sizeof data[0])));
			return verify_case(casenum__, vector <int>(expected__, expected__ + (sizeof expected__ / sizeof expected__[0])), received__, clock()-start__);
		}*/
		default:
			return -1;
		}
	}
}
 

int main(int argc, char *argv[]) {
	if (argc == 1) {
		moj_harness::run_test();
	} else {
		for (int i=1; i<argc; ++i)
			moj_harness::run_test(atoi(argv[i]));
	}
}
// END CUT HERE
