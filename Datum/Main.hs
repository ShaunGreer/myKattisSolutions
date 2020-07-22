import Data.List.Split

main::IO()
main = do
  contents <- getContents
  let date = (splitOn " " contents) !! 0
  let month = (splitOn " " contents) !! 1
  putStrLn (findDay (read date :: Int) (read month :: Int))

findDay :: Int -> Int -> String
findDay date month = case month of
  1 -> getJan date
  2 -> getFeb date
  3 -> getMar date
  4 -> getApr date
  5 -> getMay date
  6 -> getJun date
  7 -> getJul date
  8 -> getAug date
  9 -> getSep date
  10 -> getOct date
  11 -> getNov date
  12 -> getDec date

getJan :: Int -> String
getJan x = case (x`mod`7) of
  1 -> "Thursday"
  2 -> "Friday"
  3 -> "Saturday"
  4 -> "Sunday"
  5 -> "Monday"
  6 -> "Tuesday"
  0 -> "Wednesday"

getFeb :: Int -> String
getFeb x = case (x`mod`7) of
  1 -> "Sunday"
  2 -> "Monday"
  3 -> "Tuesday"
  4 -> "Wednesday"
  5 -> "Thursday"
  6 -> "Friday"
  0 -> "Saturday"

getMar :: Int -> String
getMar x = case (x`mod`7) of
  1 -> "Sunday"
  2 -> "Monday"
  3 -> "Tuesday"
  4 -> "Wednesday"
  5 -> "Thursday"
  6 -> "Friday"
  0 -> "Saturday"

getApr :: Int -> String
getApr x = case (x`mod`7) of
  1 -> "Wednesday"
  2 -> "Thursday"
  3 -> "Friday"
  4 -> "Saturday"
  5 -> "Sunday"
  6 -> "Monday"
  0 -> "Tuesday"

getMay :: Int -> String
getMay x = case (x`mod`7) of
  1 -> "Friday"
  2 -> "Saturday"
  3 -> "Sunday"
  4 -> "Monday"
  5 -> "Tuesday"
  6 -> "Wednesday"
  0 -> "Thursday"

getJun :: Int -> String
getJun x = case (x`mod`7) of
  1 -> "Monday"
  2 -> "Tuesday"
  3 -> "Wednesday"
  4 -> "Thursday"
  5 -> "Friday"
  6 -> "Saturday"
  0 -> "Sunday"

getJul :: Int -> String
getJul x = case (x`mod`7) of
  1 -> "Wednesday"
  2 -> "Thursday"
  3 -> "Friday"
  4 -> "Saturday"
  5 -> "Sunday"
  6 -> "Monday"
  0 -> "Tuesday"

getAug :: Int -> String
getAug x = case (x`mod`7) of
  1 -> "Saturday"
  2 -> "Sunday"
  3 -> "Monday"
  4 -> "Tuesday"
  5 -> "Wednesday"
  6 -> "Thursday"
  0 -> "Friday"

getSep :: Int -> String
getSep x = case (x`mod`7) of
  1 -> "Tuesday"
  2 -> "Wednesday"
  3 -> "Thursday"
  4 -> "Friday"
  5 -> "Saturday"
  6 -> "Sunday"
  0 -> "Monday"

getOct :: Int -> String
getOct x = case (x`mod`7) of
  1 -> "Thursday"
  2 -> "Friday"
  3 -> "Saturday"
  4 -> "Sunday"
  5 -> "Monday"
  6 -> "Tuesday"
  0 -> "Wednesday"

getNov :: Int -> String
getNov x = case (x`mod`7) of
  1 -> "Sunday"
  2 -> "Monday"
  3 -> "Tuesday"
  4 -> "Wednesday"
  5 -> "Thursday"
  6 -> "Friday"
  0 -> "Saturday"

getDec :: Int -> String
getDec x = case (x`mod`7) of
  1 -> "Tuesday"
  2 -> "Wednesday"
  3 -> "Thursday"
  4 -> "Friday"
  5 -> "Saturday"
  6 -> "Sunday"
  0 -> "Monday"
