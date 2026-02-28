#include <iostream>
#include <queue>
#include <unordered_map>
#include <vector>
using namespace std;

// Enum for order states
enum OrderStatus {
    CREATED,
    CONFIRMED,
    SHIPPED,
    DELIVERED,
    CANCELLED
};

// Convert enum to string (for printing)
string statusToString(OrderStatus status) {
    switch (status) {
        case CREATED: return "CREATED";
        case CONFIRMED: return "CONFIRMED";
        case SHIPPED: return "SHIPPED";
        case DELIVERED: return "DELIVERED";
        case CANCELLED: return "CANCELLED";
    }
    return "";
}

// Tracker class
class OrderLifecycleTracker {
private:
    queue<OrderStatus> unpersistedQueue;
    unordered_map<OrderStatus, int> frequencyMap;
    int totalCount = 0;

public:
    void trackOrderState(OrderStatus status) {
        unpersistedQueue.push(status);
        frequencyMap[status]++;
        totalCount++;
    }

    int getUnpersistedCount() {
        return unpersistedQueue.size();
    }

    int getTotalOrderCount() {
        return totalCount;
    }

    vector<OrderStatus> getMostFrequentStates() {
        vector<OrderStatus> result;
        if (frequencyMap.empty()) return result;

        int maxFreq = 0;
        for (auto &p : frequencyMap) {
            maxFreq = max(maxFreq, p.second);
        }

        for (auto &p : frequencyMap) {
            if (p.second == maxFreq) {
                result.push_back(p.first);
            }
        }
        return result;
    }
};

// Main function
int main() {
    OrderLifecycleTracker tracker;

    while (true) {
        cout << "\n===== ORDER TRACKER MENU =====\n";
        cout << "1. Track Order State\n";
        cout << "2. Get Unpersisted Count\n";
        cout << "3. Get Total Order Count\n";
        cout << "4. Get Most Frequent State\n";
        cout << "5. Exit\n";

        int choice;
        cin >> choice;

        switch (choice) {
            case 1: {
                cout << "Select state:\n";
                cout << "1.CREATED 2.CONFIRMED 3.SHIPPED 4.DELIVERED 5.CANCELLED\n";

                int s;
                cin >> s;

                OrderStatus status = static_cast<OrderStatus>(s - 1);
                tracker.trackOrderState(status);

                cout << "State tracked!\n";
                break;
            }

            case 2:
                cout << "Unpersisted Count: "
                     << tracker.getUnpersistedCount() << endl;
                break;

            case 3:
                cout << "Total Order Count: "
                     << tracker.getTotalOrderCount() << endl;
                break;

            case 4: {
                vector<OrderStatus> result = tracker.getMostFrequentStates();
                cout << "Most Frequent State(s): ";
                for (auto s : result) {
                    cout << statusToString(s) << " ";
                }
                cout << endl;
                break;
            }

            case 5:
                cout << "Exiting...\n";
                return 0;

            default:
                cout << "Invalid choice!\n";
        }
    }
}
