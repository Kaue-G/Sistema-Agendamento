
const offices = [
  {
    id: 'sao-paulo',
    name: 'São Paulo',
    address: 'R. Bela Cintra, 986 - 2º andar',
    compl: 'Consolação, São Paulo - SP, 01415 - 906',
    chairs: 240,
    meetRoom: 3
  },
  {
    id: 'santos',
    name: 'Santos',
    address: 'Prç. dos Expedicionários, 19 ',
    compl: 'Gonzaga, Santos-SP, 11065-500',
    chairs: 40,
    meetRoom: 2
  }
]
export function getOffices() {
  return offices
}

export function getOffice(id) {
  return offices.find((office) => office.id === id)

}

