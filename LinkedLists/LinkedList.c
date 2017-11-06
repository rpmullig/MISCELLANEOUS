/* Linked_Lists.c
**
** Author: Robert Mulligan
** Date Created: 10/15/2014
** Last Modified by: Robert Mulligan
** Date Last Modified: 10/15/2014
*/

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

 int main() {

/* user input */
int input;

/* Prototypes */
int cricket();
int linkedList();

/* User menu */
printf("--------MAIN MENU--------\n\n");
printf("Enter 1 for Cricket\n");
printf("Enter 2 for Linked List\n");
printf("Enter 3 to Exit Main Menu\n\n");

 printf("Input: ");
scanf("%d", &input);
printf("-------------------------\n\n\n");

switch(input){
case 1:
    cricket();
    return(0);
    break;
case 2:
    linkedList();
    return(0);
    break;
case 3:
    return(0);
    break;
default:
    printf("Error -- invalid input");
    return(0);
    break;
        }//end of switch
}//end of main

// http://www.cprogramming.com/snippets/source-code/singly-linked-list-insert-remove-add-count
// http://www.learn-c.org/en/Linked_lists
// https://www.cs.bu.edu/teaching/c/linked-list/delete/
// http://www.thecrazyprogrammer.com/2013/09/menu-driven-c-program-to-perform-insert.html

struct node
{
        int data;
        struct node *next;
}*start=NULL,*b,*t;

linkedList()
{
    int  option;

    void insert_beg();
    void insert_end();
    int  modify();
    void display();

    void delete_beg();
    void delete_end();

    int insert_mid();
    int delete_mid();

    while(1)
        {
    printf("Please enter your choice\n");
    printf("1. INSERT a node at the END of linklist\n");
    printf("2. INSERT a node at the BEGINNING of linklist\n");
    printf("3. DELETE a node at the END of linklist\n");
    printf("4. DELETE a node from the BEGINNING of linklist\n");
    printf("5. INSERT a node in the MIDDLE of linklist\n");
    printf("6. DELETE a node from the MIDDLE of linklist\n");
    printf("7. MODIFY any node in linklist\n");
    printf("8. EXIT\n\n");

    printf("Input: ");
    scanf("%d", &option);
    printf("\n");

    switch(option) {
        case 1: insert_end(); display(); break;
        case 2: insert_beg(); display(); break;
        case 3: delete_end(); display(); break;
        case 4: delete_beg(); display(); break;
        case 5: insert_mid(); display(); break;
        case 6: delete_mid(); display(); break;
        case 7: modify(); display(); break;
        case 8: return(0); break;
        default: printf("Error -- Wrong Input\n\n"); break;
            }
        }
return 0;
}

void insert_beg(){
    int x;

    t=(struct node*)malloc(sizeof(struct node));
    printf("Enter the value for the node you want to insert at the beginning\n");
    scanf("%d",&x);
    t->data=x;

    if(start == NULL)                 //If list is empty
        {
            t->next=NULL;
            start=t;
        }
        else
        {
            t->next=start;
            start=t;
        }
}


void insert_end(){
    int x;

    t=(struct node*)malloc(sizeof(struct node));

    printf("Enter your node in the list\n");
    scanf("%d",&x);
    t->data=x;
    t->next=NULL;

    if(start==NULL)                 //If list is empty
        {
            start=t;
        }
        else
        {
            b=start;
            while(b->next!=NULL){
                b=b->next;
            }
                b->next=t;
        }
}

int modify(){
    int position,i,x;

    t=(struct node*)malloc(sizeof(struct node));
    printf("Enter the value of the node after which you want to insert a new node\n");
    scanf("%d",&position);

    printf("\nEnter the value of new node\n");
    scanf("%d",&x);

    t->data=x;
    b=start;

    for(i = 1; i < (position-1); position++){
        b=b->next;
    }
    b=b->next;

    t->next=b->next;
    b->next=t;
    return 0;
}

void display(){
    printf("\n\nThe link list currently has these nodes:\n\n");
    b=start;

    while(b->next!=NULL)
    {
        printf("%d->" ,b->data);
        b=b->next;
    }
    printf("%d->\n\n", b->data);
}

void delete_beg(){

        b=start;
        start=start->next;
        free(b);
}

void delete_end(){
        b=start;

        while(b->next->next!=NULL)
              {
                 b=b->next;
              }

        t=b->next;
        b->next=NULL;
        free(t);

}

int delete_mid(){
int position,i;

printf("Enter position to delete\n");
scanf("%d",&position);


for(i = 1; i <(position-1); position++){
    b=b->next;
}
    t=b->next;
    b->next=t->next;
    free(t);

    return(0);
}


int insert_mid(){
int position, i, x;

printf("Enter the value of the node after which you want to insert a new node\n");
scanf("%d", &position);

t=(struct node*)malloc(sizeof(struct node));

printf("\nEnter the value of new node\n");
scanf("%d", &x);
t->data=x;

for(i = 1; i < position-1; position++){
    b=b->next;
}
    b->next=t->data;
    b=b->next;
}



struct player{
        char name[35];
        float batting_average;
        char team_name[35];
};

int cricket() {

/* 'For' Loop index ors */
  int  i, j;

  int team_count;

  printf("Enter the number of teams you wish to record: ");
  scanf("%d", &team_count);

/* to keep track of the names in a string array of teams limited at 35 characters */
  char team_names[team_count][35];

  for(i = 0; i < team_count; i++){
    printf("Enter the name(s) of the teams: ");
    scanf("%s", &team_names[i]);
    }


    int player_count;

    printf("Enter the TOTAL number of players for all teams: ");
    scanf("%d", &player_count);

    struct player league[player_count];



for(i = 0; i < player_count; i++) {
    printf("Enter the %d Player name, Team name, and batting average: ", (1+i));
    scanf("%s %s %f", &league[i].name, &league[i].team_name, &league[i].batting_average);
    printf("\n");
}

printf("Listing of players and batting average according to team names:\n\n");

for(i = 0; i < team_count; i++){

    printf("%s- \n", team_names[i]);

    for(j = 0; j < player_count; j++){

        if(strcmp(team_names[i], league[j].team_name) == 0){
            printf("\t %s %f \n", league[j].name, league[j].batting_average);
        }
    }
    printf("\n\n");
}

  return (0);
}
