## Test
### Test 1: Basecase

Input: `{ apple: 1 }, [{ name: owd, inventory: { apple: 1 } }]`  
Output: `[{ owd: { apple: 1 } }]`

### Test 2: OrderFullFilled_Warehouse_1
Input `{ apple: 1}, [{ name : owd, inventory: { apple : 2 } } ]`
Output `[{ owd : { apple : 1 } } ]`  

### Test 3: OrderFullFilled_Warehouse_2
Input: `{ apple: 10 }, [{ name: owd, inventory: { apple: 5 } }, { name: dm, inventory: { apple: 5 }}]`  
Output: `[{ dm: { apple: 5 }}, { owd: { apple: 5 } }]`

### Test4: OrderNotFullFilled_1
Input: `{ apple: 1 }, [{ name: owd, inventory: { apple: 0 } }]`  
Output: `[]`

### Test5: OrderNotFullFilled_2
Input: `{ apple: 2 }, [{ name: owd, inventory: { apple: 1 } }]`  
Output: `[]`

### Test6: Empty_Order
Input: `{}, [{ name: owd, inventory: { apple: 5 } }]`  
Output: `[]`

### Test 7:OrderFullfilled_Multiple_Items
Input: `[{ apple: 10},{orange:7 }], [{ name: owd, inventory: { apple: 5 } {orange: 5 } }, { name: dm, inventory: { apple: 5 },{orange: 3}}]`  
Output: `[{ dm: { apple: 5 } {orange: 5}}, { owd: { apple: 5 }{ orange : 2} }]`
