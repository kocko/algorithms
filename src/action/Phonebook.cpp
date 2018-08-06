#include <bits/stdc++.h>

using namespace std;

map<string, set<string>> nameToPhones, phoneToNames;

int main() {
  int q;
  cin >> q;
  while (q-- > 0) {
    string type;
    cin >> type;
    if (type == "add") {
      string name, phone;
      cin >> name >> phone;
      
      if (nameToPhones.find(name) != nameToPhones.end()) {
        nameToPhones[name].insert(phone);
      } else {
        set<string> phoneList;
        phoneList.insert(phone);
        nameToPhones[name] = phoneList;
      }
      
      if (phoneToNames.find(phone) != phoneToNames.end()) {
        phoneToNames[phone].insert(name);
      } else {
        set<string> namesList;
        namesList.insert(name);
        phoneToNames[phone] = namesList;
      }
    } else if (type == "queryname") {
      string name;
      cin >> name;
      if (nameToPhones.find(name) != nameToPhones.end()) {
        set<string> phonesList = nameToPhones[name];
        for (auto phone : phonesList) {
          cout << phone << ' ';
        }
      }
      cout << endl;
    } else if (type == "querynum") {
      string phone;
      cin >> phone;
      if (phoneToNames.find(phone) != phoneToNames.end()) {
        set<string> namesList = phoneToNames[phone];
        for (auto name : namesList) {
          cout << name << ' ';
        }
      }
      cout << endl;
    } else if (type == "delname") {
      string name;
      cin >> name;
      if (nameToPhones.find(name) != nameToPhones.end()) {
        set<string> phonesList = nameToPhones[name];
        nameToPhones.erase(name);
        for (auto phone : phonesList) {
          if (phoneToNames.find(phone) != phoneToNames.end()) {
            set<string> namesList = phoneToNames[phone];
            namesList.erase(name);
            if (namesList.size() > 0) {
              phoneToNames[phone] = namesList;
            } else {
              phoneToNames.erase(phone);
            }
          }
        }
      }
    } else if (type == "delnum") {
      string phone;
      cin >> phone;
      
      if (phoneToNames.find(phone) != phoneToNames.end()) {
        set<string> namesList = phoneToNames[phone];
        phoneToNames.erase(phone);
        for (auto name : namesList) {
          if (nameToPhones.find(name) != nameToPhones.end()) {
            set<string> phonesList = nameToPhones[name];
            phonesList.erase(phone);
            if (phonesList.size() > 0) {
              nameToPhones[name] = phonesList;
            } else {
              nameToPhones.erase(name);
            }
          }
        }
      }
    }
  }
  return 0;
}
